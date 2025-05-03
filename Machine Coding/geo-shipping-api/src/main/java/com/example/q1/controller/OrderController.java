package com.example.q1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.q1.model.Item;
import com.example.q1.model.Order;
import com.example.q1.model.User;
import com.example.q1.model.Warehouse;
import com.example.q1.service.WarehouseDetailsService;
import com.example.q1.service.WarehouseService;

import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class OrderController {

    private final WarehouseService warehouseService;
    private final WarehouseDetailsService warehouseDetailsService;
        private static final Logger logger = LoggerFactory.getLogger(OrderController.class);


    public OrderController(WarehouseService warehouseService, WarehouseDetailsService warehouseDetailsService){
        this.warehouseService = warehouseService;
        this.warehouseDetailsService = warehouseDetailsService;
        
    }
    
    // [{
    //     "itemId": "item1",
    //     "orderQty": 100,
    //     "warehouses": [
    //       {"warehouseId": "1", "warehouseQty": 10},
    //       {"warehouseId": "6", "warehouseQty": 40},
    //       {"warehouseId": "30", "warehouseQty": 50}
    //     ]
    //   },
    //   {
    //     "itemId": "item2",
    //     "orderQty": 30,
    //     "warehouses": [
    //       {"warehouseId": "1", "warehouseQty": 0},
    //       {"warehouseId": "4", "warehouseQty": 47},
    //       {"warehouseId": "30", "warehouseQty": 2}
    //     ]
    //   }]
    
    @PostMapping("/processOrder")
    public ResponseEntity<?> processOrder(@RequestBody List<Map<String, Object>> orderItemsData,HttpSession session){
        
        User currentUser = (User) session.getAttribute("loggedInUser");
        logSessionAttributes(session);

        if(currentUser == null){
            return ResponseEntity.badRequest().body("User not logged in or session expired");
        }

        Map<String,List<Map<String, String>>> itemShipments = new HashMap<>();
        
        for(Map<String,Object> itemData : orderItemsData){
            String itemId = (String) itemData.get("itemId");
            int orderQty = (Integer) itemData.get("orderQty");
            List<Map<String,Object>> warehousesData = (List<Map<String,Object>>) itemData.get("warehouses");
            Item item = new Item();
            item.setItemId(itemId);
            item.setOrderQty(orderQty);
            List<WarehouseDistance> warehouseDistances = new ArrayList<>();
            
            // Calculate distance of all provided warehouses for the current item
            for(Map<String,Object> warehouseInfo : warehousesData){
                String warehouseId = String.valueOf(warehouseInfo.get("warehouseId"));
                int warehouseQty = Integer.parseInt(String.valueOf(warehouseInfo.get("warehouseQty")));
                Warehouse warehouse = warehouseDetailsService.getWarehouseDetails(warehouseId);
                
                
                if(warehouse != null){
                    double distance = warehouseService.distance(currentUser, warehouse);
                    warehouseDistances.add(new WarehouseDistance(warehouse, distance, warehouseQty));
                }
            } 

            warehouseDistances.sort(Comparator.comparingDouble(WarehouseDistance::getDistance));
            int remainQty = orderQty;
            List<Map<String,String>> shipmentsForItem = new ArrayList<>();
            for(WarehouseDistance wd : warehouseDistances){
                if (remainQty <= 0){
                    break;
                }
                Warehouse warehouse = wd.getWarehouse();
                int avaibleQty = wd.getQuantity();
                int qtyToShip = Math.min(remainQty,avaibleQty);

                if(qtyToShip > 0){
                    shipmentsForItem.add(Map.of(
                        "warehouseId",warehouse.getWarehouseId(),
                        "quantity",String.valueOf(qtyToShip)
                    ));
                    remainQty = remainQty - qtyToShip;
                }
            }
            if(remainQty == 0){
                itemShipments.put(itemId,shipmentsForItem);
            } else {
                itemShipments.put(itemId,List.of(Map.of("message","Could not fulfill full quantity for item "+itemId)));
            }
           

        }
        return ResponseEntity.ok(itemShipments);
    }

    private static class WarehouseDistance{
        private final Warehouse warehouse;
        private final double distance;
        private final int quantity;
        
        public WarehouseDistance(Warehouse warehouse, double distance, int quantity){
            this.warehouse = warehouse;
            this.distance = distance;
            this.quantity = quantity;
        }

        public Warehouse getWarehouse() {
            return warehouse;
        }

        public double getDistance() {
            return distance;
        }

        public int getQuantity() {
            return quantity;
        }

        
    }


    private void logSessionAttributes(HttpSession session) {
        logger.info("Session Attributes (ID: {}):", session.getId());
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            Object value = session.getAttribute(name);
            logger.info("  {}: {}", name, value);
        }
    }
    
}

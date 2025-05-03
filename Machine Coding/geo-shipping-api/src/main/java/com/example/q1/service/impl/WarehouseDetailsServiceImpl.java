package com.example.q1.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.q1.model.Warehouse;
import com.example.q1.service.WarehouseDetailsService;

@Service
public class WarehouseDetailsServiceImpl implements WarehouseDetailsService {

    private static final Map<String,Warehouse> warehouseLocations = new HashMap<>();
    
    static {
        Warehouse wh1 = new Warehouse();
        wh1.setWarehouseId("1");
        wh1.setWarehouseLatitude(40.7128);   // Example: New York
        wh1.setWarehouseLongitude(-74.0060);
        warehouseLocations.put("1", wh1);

        Warehouse wh2 = new Warehouse();
        wh2.setWarehouseId("2");
        wh2.setWarehouseLatitude(34.0522);   // Example: Los Angeles
        wh2.setWarehouseLongitude(-118.2437);
        warehouseLocations.put("2", wh2);

        Warehouse wh3 = new Warehouse();
        wh3.setWarehouseId("3");
        wh3.setWarehouseLatitude(41.8781);  // Example: Chicago
        wh3.setWarehouseLongitude(-87.6298);
        warehouseLocations.put("3", wh3);

        Warehouse wh4 = new Warehouse();
        wh4.setWarehouseId("4");
        wh4.setWarehouseLatitude(39.7392);   // Example: Denver
        wh4.setWarehouseLongitude(-104.9903);
        warehouseLocations.put("4", wh4); 
    }
    @Override
    public Warehouse getWarehouseDetails(String warehouseId) {
        return warehouseLocations.get(warehouseId);
    }
    
}

package com.example.q1.model;

import java.util.HashMap;

public class Warehouse {
    private String warehouseId;
    private double warehouseLongitude;
    private double warehouseLatitude;
    private HashMap<String, Integer> itemQuantities = new HashMap<>();

    public Warehouse() {

    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public double getWarehouseLongitude() {
        return warehouseLongitude;
    }

    public void setWarehouseLongitude(double warehouseLongitude) {
        this.warehouseLongitude = warehouseLongitude;
    }

    public double getWarehouseLatitude() {
        return warehouseLatitude;
    }

    public void setWarehouseLatitude(double warehouseLatitude) {
        this.warehouseLatitude = warehouseLatitude;
    }

    public HashMap<String, Integer> getItemQuantities() {
        return itemQuantities;
    }

    public void setItemQuantities(HashMap<String, Integer> itemQuantities) {
        this.itemQuantities = itemQuantities;
    }
    public void addItemQuantity(String itemId,int quantity){
        itemQuantities.put(itemId,quantity);
    }
   
}

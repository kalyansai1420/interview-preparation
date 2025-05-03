package com.example.q1.service.impl;

import org.springframework.stereotype.Service;

import com.example.q1.model.User;
import com.example.q1.model.Warehouse;
import com.example.q1.service.WarehouseService;

@Service
public class WarehouseServiceImpl implements WarehouseService{

    private static final int EARTH_RADIUS_KM = 6371;

    @Override
    public double distance(User user, Warehouse warehouse) {
        
        double userLat = user.getLatitude();
        double userLong = user.getLongitude();
        double warehouseLat = warehouse.getWarehouseLatitude();
        double warehouseLong = warehouse.getWarehouseLongitude();

        double dLong = Math.toRadians(warehouseLong-userLong);
        double dLat = Math.toRadians(warehouseLat-userLat);
        double a = Math.pow(Math.sin(dLat/2),2) + Math.cos(Math.toRadians(userLat)) * Math.cos(Math.toRadians(warehouseLat)) * Math.pow(Math.sin(dLong/2),2);
        double c = 2 * Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return EARTH_RADIUS_KM * c;
    }
    
}

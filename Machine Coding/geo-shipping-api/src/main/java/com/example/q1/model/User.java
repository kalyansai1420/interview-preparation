package com.example.q1.model;

import java.io.Serializable;

import jakarta.persistence.Entity;

@Entity
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private double latitude;
    private double longitude;
    
    public User(){

    }
    public User(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    
}

package com.traficManage.SmartTrafficSystem;

public class VehicleEvent {
    private String vehicleId;
    private double speed;
    private String zone;
    private boolean isEmergencyVehicle;

    // Getters and Setters so Spring Boot can read the data
    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public String getZone() { return zone; }
    public void setZone(String zone) { this.zone = zone; }

    public boolean isEmergencyVehicle() { return isEmergencyVehicle; }
    public void setEmergencyVehicle(boolean emergencyVehicle) { this.isEmergencyVehicle = emergencyVehicle; }
}
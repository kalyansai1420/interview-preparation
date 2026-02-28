public abstract class ParkingSpot {
    private String spotId;
    private boolean isAvailable = true;
    private VehicleType supportedVehicleType;

    public ParkingSpot(String spotId, VehicleType type) {
        this.spotId = spotId;
        this.supportedVehicleType = type;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void parkVehicle() {
        isAvailable = false;
    }

    public void removeVehicle() {
        isAvailable = true;
    }

    public VehicleType getSupportedVehicleType() {
        return supportedVehicleType;
    }
}

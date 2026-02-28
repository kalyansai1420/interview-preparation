public class NearestSpotStrategy implements SpotAssignmentStrategy {
    
    @Override
    public ParkingSpot assignSpot(
        Vehicle vehicle,
                List<ParkingSpot> floors
    ) {
        for (ParkingFloor floor : floors) {
            for (ParkingSpot spot : floor.getParkingSpots()) {
                if (spot.isAvailable() && spot.getSupportedVehicleType() == vehicle.getVehicleType()) {
                    return spot;
                }
            }
        }
        return null;
    }
}

public class ParkingLot {
    private List<ParkingFloor> floors;
    private SpotAssignmentStrategy spotStrategy;

    public ParkingLot(List<ParkingFloor> floors, SpotAssignmentStrategy strategy) {
        this.floors = floors;
        this.spotStrategy = strategy;
    }

    public Ticket assignTicket(Vehicle vehicle) {
        ParkingSpot spot = spotStrategy.assignSpot(vehicle, floors);

        if (spot == null) {
            throw new RuntimeException("Parking Full");
        }

        spot.parkVehicle();
        return new Ticket(UUID.randomUUID().toString(), vehicle, spot);
    }
}

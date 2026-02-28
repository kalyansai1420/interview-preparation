public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(
        Vehicle vehicle,
        List<ParkingSpot> floors
    );
}

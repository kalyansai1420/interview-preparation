public class Request {
    int sourceFloor;
    int destinationFloor;
    Direction direction;

    Request(int source, int dest) {
        this.sourceFloor = source;
        this.destinationFloor = dest;
        this.direction = dest > source ? Direction.UP : Direction.DOWN;
    }
}

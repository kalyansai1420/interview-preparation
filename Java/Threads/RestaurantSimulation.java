public class RestaurantSimulation {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread waiter = new WaiterThread(lock);
        Thread chef = new ChefThread(lock);
        waiter.start();
        chef.start();
    }
}

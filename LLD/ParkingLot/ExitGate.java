class ExitGate {
    private PricingStrategy pricingStrategy;

    public ExitGate(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double processExit(Ticket ticket) {
        ticket.getParkingSpot().removeVehicle();
        return pricingStrategy.calculatePrice(
                ticket, LocalDateTime.now());
    }
}

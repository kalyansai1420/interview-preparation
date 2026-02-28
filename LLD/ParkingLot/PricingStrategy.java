public interface PricingStrategy {
    double calculatePrice(Ticket ticket, LocalDateTime exitTime);
}

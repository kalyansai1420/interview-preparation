import java.time.Duration;

public class HourlyPricingStrategy implements PricingStrategy {
    
    @Override
    public double calculatePrice(Ticket ticket, LocalDateTime exitTime) {
        long hours = Duration.between(
                ticket.getEntryTime(), exitTime).toHours();
        return Math.max(1, hours) * 50 ;
    }
}

package problems.parkinglot.strategy;

import java.time.Duration;

import problems.parkinglot.models.Ticket;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public double calculateFee(Ticket ticket) {
        long hours = Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours();

        if(hours == 0) hours = 1;

        return hours * 20;
    }
    
}

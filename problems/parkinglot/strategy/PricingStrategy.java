package problems.parkinglot.strategy;

import problems.parkinglot.models.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}

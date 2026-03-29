package problems.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import problems.parkinglot.enums.TicketStatus;
import problems.parkinglot.models.ParkingLot;
import problems.parkinglot.models.ParkingSpot;
import problems.parkinglot.models.Ticket;
import problems.parkinglot.models.vehicle.Vehicle;
import problems.parkinglot.strategy.PricingStrategy;

public class ParkingManager {
    private ParkingLot parkingLot;
    private Map<String, Ticket> activeTickets;
    private PricingStrategy pricingStrategy;

    ParkingManager(ParkingLot lot, PricingStrategy pricingStrategy) {
        this.parkingLot = lot;
        this.pricingStrategy = pricingStrategy;

        this.activeTickets = new HashMap<>();
    }

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = this.parkingLot.findSpot(vehicle);

        if(spot == null) {
            throw new RuntimeException("No spot available");
        }

        spot.park(vehicle);

        Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, spot);

        activeTickets.put(vehicle.getNumberPlate(), ticket);
        
        return ticket;
    }

    public double exitVehicle(String numberPlate) {
        Ticket ticket = activeTickets.get(numberPlate);

        if(ticket == null) {
            throw new RuntimeException("Invalid ticket");
        }

        if(ticket.getStatus() == TicketStatus.CLOSED) {
            throw new RuntimeException("Ticket is not active");
        }

        ticket.closeTicket();

        ticket.getSpot().vacate();

        activeTickets.remove(numberPlate);

        return this.pricingStrategy.calculateFee(ticket);
    }
}

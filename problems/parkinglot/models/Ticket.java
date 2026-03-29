package problems.parkinglot.models;

import java.time.LocalDateTime;

import problems.parkinglot.enums.TicketStatus;
import problems.parkinglot.models.vehicle.Vehicle;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot spot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
        this.status = TicketStatus.ACTIVE;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        this.status = TicketStatus.CLOSED;
    }

        public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public String getTicketId() {
        return this.ticketId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public TicketStatus getStatus() {
        return this.status;
    }

}

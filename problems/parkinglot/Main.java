package problems.parkinglot;

import java.util.Arrays;

import problems.parkinglot.models.ParkingFloor;
import problems.parkinglot.models.ParkingLot;
import problems.parkinglot.models.Ticket;
import problems.parkinglot.models.vehicle.Car;
import problems.parkinglot.models.vehicle.Vehicle;
import problems.parkinglot.strategy.HourlyPricingStrategy;

public class Main {

    public static void main(String[] args) {
        ParkingFloor f1 = new ParkingFloor(1, 2, 2, 1);
        ParkingFloor f2 = new ParkingFloor(2, 2, 2, 2);

        ParkingLot lot = new ParkingLot(Arrays.asList(f1, f2));

        ParkingManager manager = new ParkingManager(lot, new HourlyPricingStrategy());

        Vehicle car = new Car("DL01AB1234");

        Ticket ticket = manager.parkVehicle(car);

        System.out.println("Parked with ticketId: " + ticket.getTicketId());

        double fee = manager.exitVehicle("DL01AB1234");

        System.out.println("Fee = " + fee);
    }
    
}
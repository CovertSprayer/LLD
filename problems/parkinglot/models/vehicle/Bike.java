package problems.parkinglot.models.vehicle;

import problems.parkinglot.enums.VehicleType;

public class Bike extends Vehicle {
    
    public Bike(String numberPlate) {
        super(numberPlate, VehicleType.BIKE);
    }

}

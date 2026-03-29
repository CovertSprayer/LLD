package problems.parkinglot.models.vehicle;

import problems.parkinglot.enums.VehicleType;

public class Car extends Vehicle {

    public Car(String numberPlate) {
        super(numberPlate, VehicleType.CAR);
    }
    
}

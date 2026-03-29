package problems.parkinglot.models.vehicle;

import problems.parkinglot.enums.VehicleType;

public abstract class Vehicle {
    
    private String numberPlate;
    private VehicleType vehicleType;

    Vehicle(String numberPlate, VehicleType vehicleType) {
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType(){
        return this.vehicleType;
    };

    public String getNumberPlate() { return this.numberPlate; }
}

package problems.parkinglot.models;

import problems.parkinglot.enums.SpotType;
import problems.parkinglot.models.vehicle.Vehicle;

public class ParkingSpot {
    private String spotId;
    private int floorNumber;
    private SpotType spotType;
    private boolean isOccupied;

    public ParkingSpot(String spotId, int floorNumber, SpotType type) {
        this.spotId = spotId;
        this.floorNumber = floorNumber;
        this.spotType = type;
    }

    public boolean canFitVehicle(Vehicle vechile) {
        switch (vechile.getVehicleType()) {
            case BIKE:
                return spotType == SpotType.SMALL;
            
            case CAR:
                return spotType == SpotType.MEDIUM || spotType == SpotType.LARGE;

            case TRUCK:
                return spotType == SpotType.LARGE;
        }

        return false;
    }

    public boolean park(Vehicle vehicle) {
        if(isOccupied || !canFitVehicle(vehicle)) return false;

        this.isOccupied = true;
        return true;
    }

    public void vacate() {
        this.isOccupied = false;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public String getSpotId() { return this.spotId; }
    public int getFloorNumber() { return this.floorNumber; }
    public SpotType getSpotType() { return this.spotType; }
}

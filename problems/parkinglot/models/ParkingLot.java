package problems.parkinglot.models;

import java.util.List;

import problems.parkinglot.models.vehicle.Vehicle;

public class ParkingLot {
    private List<ParkingFloor> floors;

    public ParkingLot(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public ParkingSpot findSpot(Vehicle vehicle) {
        for(ParkingFloor floor: floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);

            if(spot != null) return spot;
        }

        return null;
    }

    public List<ParkingFloor> getFloors() {
        return this.floors;
    }
}

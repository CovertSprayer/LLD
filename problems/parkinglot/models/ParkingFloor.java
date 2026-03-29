package problems.parkinglot.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import problems.parkinglot.enums.SpotType;
import problems.parkinglot.models.vehicle.Vehicle;

public class ParkingFloor {
    private int floorNumber;
    private Map<SpotType, List<ParkingSpot>> spotMap;

    public ParkingFloor(int floorNumber, int smallSpotCount, int mediumSpotCount, int largeSpotCount) {
        this.floorNumber = floorNumber;
        this.spotMap = new HashMap<>();

        spotMap.put(SpotType.SMALL, createSpots(smallSpotCount, SpotType.SMALL));
        spotMap.put(SpotType.MEDIUM, createSpots(mediumSpotCount, SpotType.MEDIUM));
        spotMap.put(SpotType.LARGE, createSpots(largeSpotCount, SpotType.LARGE));
    }

    private List<ParkingSpot> createSpots (int count, SpotType type) {
        List<ParkingSpot> spots = new ArrayList<>();

        for(int i=1; i<=count; i++) {
            String spotId = "F" + floorNumber + type.toString().charAt(0) + i;
            spots.add(new ParkingSpot(spotId, this.floorNumber, type));
        }

        return spots;
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for(List<ParkingSpot> spots : spotMap.values()) {
            for(ParkingSpot spot : spots) {
                if(!spot.isOccupied() && spot.canFitVehicle(vehicle)) return spot;
            }
        }
        return null;
    }

    public void getSpots() {
        for(var entry: spotMap.entrySet()) {
            for(ParkingSpot spot : entry.getValue()) {
                System.out.println(spot.getSpotId());
            }
        }
    }
}

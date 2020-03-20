package ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {

    Map<vehicleType, ArrayList<vehicleInformation>> parkingList;

    public ParkingLotAnalyser() {
        this.parkingList = new HashMap<>();
    }
    public Map<vehicleType,  ArrayList<vehicleInformation>> allocatePlaceToParkTheVehicle(vehicleType type,vehicleInformation... information) {
        if (information != null) {
            parkingList.put(type, new ArrayList<vehicleInformation>(5));
            for (vehicleInformation i : information) {
                parkingList.get(type).add(i);
            }
            return parkingList;
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Parking-Lot");
    }
}



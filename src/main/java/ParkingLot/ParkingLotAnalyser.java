package ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {

    Map<String, vehicleInformation> parkingList = new HashMap<>();

    public Map<String, vehicleInformation> allocatePlaceToParkTheVehicle(vehicleInformation information) {
        if (information != null) {
            parkingList.put("vehicle",information);
            parkingList.get("vehicle");
            return parkingList;
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Parking-Lot");
    }
}



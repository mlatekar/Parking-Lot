package ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {

    Map<String, ArrayList<vehicleInformation>> parkingList;

    public ParkingLotAnalyser() {
        this.parkingList = new HashMap<>();
    }
    public Map<String,  ArrayList<vehicleInformation>> allocatePlaceToParkTheVehicle(vehicleInformation... information) {
        if (information != null) {
            parkingList.put("vehicle",new ArrayList<vehicleInformation>(5));
            for (vehicleInformation i : information) {
                parkingList.get("vehicle").add(i);
            }
            return parkingList;
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Parking-Lot");
    }
}



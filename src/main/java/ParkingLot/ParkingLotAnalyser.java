package ParkingLot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParkingLotAnalyser {

    Map<vehicleType, ArrayList<vehicleInformation>> parkingList;
    ArrayList<vehicleInformation> totalDeatilOfVehicles = new ArrayList<>();

    public ParkingLotAnalyser() {
        this.parkingList = new HashMap<>();
    }

    public Map<vehicleType, ArrayList<vehicleInformation>> allocatePlaceToParkTheVehicle(vehicleType type, vehicleInformation... information) {
        if (information != null) {
            parkingList.put(type, totalDeatilOfVehicles);
            for (vehicleInformation i : information) {
                parkingList.get(type).add(i);
            }
            return parkingList;
        }
        return null;
    }

    public boolean unparkTheVehicleFromParkingLot(String numberPlate) throws ParkingLotException {
        try {
            totalDeatilOfVehicles.size();
            for (int i = 0; i < totalDeatilOfVehicles.size(); i++) {
                if (totalDeatilOfVehicles.get(i).numberPlate.equals(numberPlate)) {
                    System.out.println("Vehicle Unpark successfully" + totalDeatilOfVehicles.get(i).numberPlate);
                    totalDeatilOfVehicles.remove(i);
                    return true;
                }
            }return false;
        }catch (ParkingLotException e) {
            throw new ParkingLotException("Vehicle not found", ParkingLotException.ExceptionType.VEHICLE_NOT_FOUND);
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Parking-Lot");
    }
}



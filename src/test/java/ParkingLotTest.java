import ParkingLot.ParkingLotAnalyser;
import ParkingLot.vehicleInformation;
import ParkingLot.vehicleType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;


public class ParkingLotTest {
    ParkingLotAnalyser parkingLotAnalyser = null;

    @Before
    public void beforeClass() throws Exception {

        parkingLotAnalyser = new ParkingLotAnalyser();
    }
    @Test
    public void givenParkingLot_OwnerCheck_parkingLotIs_Empty_ToParkVehicle() {
        ParkingLotAnalyser parkingLotAnalyser=new ParkingLotAnalyser();
        Map<vehicleType,  ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.SMALL,new vehicleInformation("MH05 DX 8331","Red","12:13"));
        Assert.assertEquals(1,parkVehicle.get(vehicleType.SMALL).size());
    }

    @Test
    public void givenParkingLot_MultipleCar_CanParkInParkingLot_() {
        ParkingLotAnalyser parkingLotAnalyser=new ParkingLotAnalyser();
        Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.LARGE,new vehicleInformation("MH05 DX 8331","Red","12:13"),
                        new vehicleInformation("MH01 MJ 0110","Blue","1:23"));
        Assert.assertEquals(2,parkVehicle.get(vehicleType.LARGE).size());

    }
    @Test
    public void givenParkingLot_MultipleCar_WithMultipleTypes() {
        ParkingLotAnalyser parkingLotAnalyser=new ParkingLotAnalyser();
        Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.HANDICAPPED,new vehicleInformation("MH05 DX 8331","Red","12:13"),
                        new vehicleInformation("MH01 MJ 0110","Blue","1:23"),
        new vehicleInformation("MH46 DP 0007","White","4:23"));
        Assert.assertEquals(3,parkVehicle.get(vehicleType.HANDICAPPED).size());

    }
}
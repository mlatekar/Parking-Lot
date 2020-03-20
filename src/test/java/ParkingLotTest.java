import ParkingLot.ParkingLotAnalyser;
import ParkingLot.vehicleInformation;
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
        Map<String,  ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(new vehicleInformation("MH05 DX 8331","Red","12:13"));
        Assert.assertEquals(1,parkVehicle.get("vehicle").size());
    }

    @Test
    public void givenParkingLot_MultipleCar_CanParkInParkingLot_() {
        ParkingLotAnalyser parkingLotAnalyser=new ParkingLotAnalyser();
        Map<String, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(new vehicleInformation("MH05 DX 8331","Red","12:13"),
                        new vehicleInformation("MH01 MJ 0110","Blue","1:23"));
        Assert.assertEquals(2,parkVehicle.get("vehicle").size());

    }
}
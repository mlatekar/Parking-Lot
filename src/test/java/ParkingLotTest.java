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
        Map<String, vehicleInformation> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(new vehicleInformation("MH05 DX 8331","Red","12:13"));
        Assert.assertEquals("MH05 DX 8331",parkVehicle.get("vehicle").numberPlate);
    }

}
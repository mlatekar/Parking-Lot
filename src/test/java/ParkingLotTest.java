import ParkingLot.ParkingLotAnalyser;
import ParkingLot.ParkingLotException;
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
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.SMALL, new vehicleInformation("MH05 DX 8331", "Red", "12:13"));
        Assert.assertEquals(1, parkVehicle.get(vehicleType.SMALL).size());
    }

    @Test
    public void givenParkingLot_MultipleCar_CanParkInParkingLot_() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.LARGE, new vehicleInformation("MH05 DX 8331", "Red", "12:13"),
                        new vehicleInformation("MH01 MJ 0110", "Blue", "1:23"));
        Assert.assertEquals(2, parkVehicle.get(vehicleType.LARGE).size());

    }

    @Test
    public void givenParkingLot_MultipleCar_WithMultipleTypes() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.HANDICAPPED, new vehicleInformation("MH05 DX 8331", "Red", "12:13"),
                        new vehicleInformation("MH01 MJ 0110", "Blue", "1:23"),
                        new vehicleInformation("MH46 DP 0007", "White", "4:23"));
        Assert.assertEquals(3, parkVehicle.get(vehicleType.HANDICAPPED).size());

    }

    @Test
    public void givenParkingLot_DriverCan_UnparkThe_CarShouldReturnTrue() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.SMALL, new vehicleInformation("MH05 CO 7788", "Black", "9:45"),
                        new vehicleInformation("MH01 MU 0707", "Yellow", "10:00"),
                        new vehicleInformation("MH02 DM 0619", "Grey", "10:05"));
        boolean unparkVehicle = parkingLotAnalyser.unparkTheVehicleFromParkingLot("MH01 MU 0707");
        Assert.assertTrue(unparkVehicle);
        System.out.println(unparkVehicle + "vehicle unpark");
    }

    @Test
    public void givenParkingLot_IsWhenFulled_ShouldReturnTrue() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
        Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                allocatePlaceToParkTheVehicle(vehicleType.SMALL,
                        new vehicleInformation("MH43 TY 8976", "White", "8:09"),
                        new vehicleInformation("MH01 MU 0707", "Yellow", "10:19"),
                        new vehicleInformation("MH05 DM 0001", "Grey", "10:00"),
                        new vehicleInformation("MH34 GJ 0110", "Red", "12:56"),
                        new vehicleInformation("MH46 JB 4154", "Purple", "2:24"),
                        new vehicleInformation("MH12 DX 8331", "Black", "3:00"),
                        new vehicleInformation("MH02 MJ 0619", "White-Red", "5:04"));
        Assert.assertNotEquals(7,parkVehicle.get(vehicleType.SMALL).size());
    }

    @Test
    public void givenParkingLot_AirportSecurityPersonLikeToKnow_WhenParkingLotIs_Fulled_AndReturnTrue_WhenItIsFulled() {
        ParkingLotAnalyser parkingLotAnalyser = new ParkingLotAnalyser();
       try {
           Map<vehicleType, ArrayList<vehicleInformation>> parkVehicle = parkingLotAnalyser.
                   allocatePlaceToParkTheVehicle(vehicleType.SMALL,
                           new vehicleInformation("MH43 TY 8976", "White", "8:09"),
                           new vehicleInformation("MH01 MU 0707", "Yellow", "10:19"),
                           new vehicleInformation("MH05 DM 0001", "Grey", "10:00"),
                           new vehicleInformation("MH34 GJ 0110", "Red", "12:56"),
                           new vehicleInformation("MH46 JB 4154", "Purple", "2:24"),
                           new vehicleInformation("MH12 DX 8331", "Black", "3:00"),
                           new vehicleInformation("MH02 MJ 0619", "White-Red", "5:04"));
           Assert.assertNotEquals(7, parkVehicle.get(vehicleType.SMALL).size());
       }catch(ParkingLotException e) {
           throw new ParkingLotException("Parking Full", ParkingLotException.ExceptionType.PARKING_IS_FULLED);
       }
    }
}
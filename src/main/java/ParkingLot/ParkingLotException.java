package ParkingLot;

public class ParkingLotException extends RuntimeException {
    public enum ExceptionType {
        PARKING_IS_FULLED, VEHICLE_NOT_FOUND
    }
    ExceptionType type;
    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type=type;
    }
}

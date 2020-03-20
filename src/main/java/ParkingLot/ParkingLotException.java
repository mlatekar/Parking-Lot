package ParkingLot;

public class ParkingLotException extends RuntimeException {
    enum ExceptionType {
        VEHICLE_NOT_FOUND
    }
    ExceptionType type;
    public ParkingLotException(String message, ExceptionType type) {
        super(message);
        this.type=type;
    }
}

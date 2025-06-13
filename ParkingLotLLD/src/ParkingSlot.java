import Models.VehicleType;

public class ParkingSlot {
    int slotID;
    VehicleType slotType;
    boolean isAvailable;

    public ParkingSlot(int slotID, VehicleType slotType) {
        this.slotID = slotID;
        this.slotType = slotType;
        isAvailable = true;
    }

    boolean parkVehicle() {
        //condition if parking fails, return false;

        isAvailable = false;
        return true;
    }

    boolean unparkVehicle() {
        //condition if unparking fails, return false;

        isAvailable = true;
        return true;
    }
}

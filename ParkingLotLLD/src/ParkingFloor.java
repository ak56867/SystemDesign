import Models.Vehicle;
import Models.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    int floorID;
    int numSlots;
    boolean isTruckFull, isBikeFull, isCarFull;
    List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorID, int numSlots) {
        this.floorID = floorID;
        this.numSlots = numSlots;
        isTruckFull = false;
        isBikeFull = false;
        isCarFull = false;
        parkingSlots = new ArrayList<>();
        createParkingSlots(numSlots);
    }

    //creating parkingslots and adding to list
    void createParkingSlots(int numSlots) {
        ParkingSlot emptyPS = new ParkingSlot(0, null);
        parkingSlots.add(emptyPS);

        for(int i=1;i<=numSlots;i++) {
            ParkingSlot parkingSlot;
            if(i == 1)                  parkingSlot = new ParkingSlot(i, VehicleType.TRUCK);
            else if (i == 2 || i == 3)  parkingSlot = new ParkingSlot(i, VehicleType.BIKE);
            else                        parkingSlot = new ParkingSlot(i, VehicleType.CAR);

            parkingSlots.add(parkingSlot);
        }
    }

    //retrieve available parking spot, mark it as parked and return value
    int parkVehicle(Vehicle vehicle) {
        int slot = getFreeSlot(vehicle.vehicleType);
        if(slot == 0)   return 0;

        parkingSlots.get(slot).parkVehicle();
        return slot;
    }

    Boolean unpark(VehicleType vehicleType, int id) {
        if(parkingSlots.get(id).slotType != vehicleType || parkingSlots.get(id).isAvailable)    return false;
        switch (vehicleType) {
            case TRUCK -> isTruckFull = false;
            case BIKE -> isBikeFull = false;
            case CAR -> isCarFull = false;
        }
        return parkingSlots.get(id).unparkVehicle();
    }

    //find available parking spot
    int getFreeSlot(VehicleType vehicleType)  {
        if(vehicleType == VehicleType.TRUCK) {
            if(parkingSlots.get(1).isAvailable)    {
                isTruckFull = true;
                return 1;
            }
            return 0;
        } else if(vehicleType == VehicleType.BIKE) {
            for(int i=2;i<=3;i++) {
                if (parkingSlots.get(i).isAvailable) {
                    if(i == 3)
                        isBikeFull = true;
                    return i;
                }
            }
            return 0;
        } else {
            for(int i=4;i<=numSlots;i++) {
                if (parkingSlots.get(i).isAvailable) {
                    if(i == numSlots)
                        isCarFull = true;
                    return i;
                }
            }
            return 0;
        }
    }
}

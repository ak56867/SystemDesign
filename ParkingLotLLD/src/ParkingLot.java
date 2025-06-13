import Models.Vehicle;
import Models.VehicleType;
import org.graalvm.collections.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    String parkingLotID;
    int numFloors;
    int numSlots;
    List<ParkingFloor> parkingFloors;
    HashMap<String, Vehicle> mapper;

    public ParkingLot(int numFloors, int numSlots) {
        this.parkingLotID = "PR1234";
        this.numFloors = numFloors;
        this.numSlots = numSlots;
        parkingFloors = new ArrayList<>();
        mapper = new HashMap<>();
        createParkingFloors(numFloors,numSlots);
    }

    void createParkingFloors(int numFloors, int numSlots) {
        ParkingFloor emptyPF = new ParkingFloor(0,0);
        parkingFloors.add(emptyPF);

        for(int i=1;i<=numFloors;i++) {
            ParkingFloor parkingFloor = new ParkingFloor(i,numSlots);
            parkingFloors.add(parkingFloor);
        }
    }

    String parkVehicle(Vehicle vehicle) {
        int floorID = 0, slotID = 0;

        for(int i=1;i<=numFloors;i++) {
            if(vehicle.vehicleType == VehicleType.CAR && !parkingFloors.get(i).isCarFull) {
                slotID = parkingFloors.get(i).parkVehicle(vehicle);
                floorID = i;
                break;
            }
            else if(vehicle.vehicleType == VehicleType.BIKE && !parkingFloors.get(i).isBikeFull) {
                slotID = parkingFloors.get(i).parkVehicle(vehicle);
                floorID = i;
                break;
            } else if(vehicle.vehicleType == VehicleType.TRUCK && !parkingFloors.get(i).isTruckFull) {
                slotID = parkingFloors.get(i).parkVehicle(vehicle);
                floorID = i;
                break;
            }
        }

        if(floorID == 0 ||  slotID == 0)  return null;
        String ticketID = parkingLotID +"_"+String.valueOf(floorID) +"_"+String.valueOf(slotID);
        Ticket ticket = new Ticket(vehicle, ticketID);
        mapper.put(ticketID,vehicle);
        System.out.println("Parked vehicle. Ticket ID: " + ticketID);
        return ticketID;
    }

    boolean unparkVehicle(String ticketID) {
        int floorID = 0, slotID = 0;

        String[] tokens = ticketID.split("_");
        floorID = Integer.parseInt(tokens[1]);
        slotID = Integer.parseInt(tokens[2]);

        Vehicle vehicle = mapper.get(ticketID);
        if(floorID > numFloors || floorID < 1 || slotID > numSlots || slotID < 1 || !parkingFloors.get(floorID).unpark(vehicle.vehicleType,slotID))   return false;
        System.out.println("Unparked vehicle with Registration Number: " + vehicle.reg_no + " " + vehicle.color);
        return true;
    }
}

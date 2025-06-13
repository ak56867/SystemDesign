import Models.Vehicle;
import Models.VehicleType;
import java.util.Scanner;

public class Main {
    static ParkingLot createParkingLot(String floors, String slots) {
        int numFloors = Integer.parseInt(floors);
        int numSlots = Integer.parseInt(slots);

        ParkingLot parkingLot = new ParkingLot(numFloors,numSlots);
        return parkingLot;
    }
    static String parkVehicle(ParkingLot parkingLot, String vehicleType, String reg_no, String color) {
        VehicleType type = (vehicleType == "TRUCK") ? VehicleType.TRUCK : (vehicleType == "BIKE") ? VehicleType.BIKE : VehicleType.CAR;
        Vehicle vehicle = new Vehicle(reg_no,type,color);
        String ticketID = parkingLot.parkVehicle(vehicle);
        return ticketID;
    }
    static Boolean unparkVehicle(ParkingLot parkingLot, String ticketID) {
        return parkingLot.unparkVehicle(ticketID);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter command:");
        String command = sc.nextLine();
        String[] token = command.split(" ");
        ParkingLot parkingLot = createParkingLot(token[2],token[3]);

        while (true) {
            //System.out.println("Enter command:");
            String commands = sc.nextLine();

            String[] tokens = commands.split(" ");

            switch (tokens[0]) {
                case "park_vehicle" -> {
                    if(parkVehicle(parkingLot,tokens[1],tokens[2],tokens[3]) == null)
                        System.out.println("Parking Lot Full");
                }
                case "unpark_vehicle" -> {
                    if(unparkVehicle(parkingLot,tokens[1]) == false)
                        System.out.println("Invalid Ticket");
                }
                case "display" -> {

                }
                case "exit" -> {
                    break;
                }
            }
        }
    }
}
//create_parking_lot PR1234 2 6
//park_vehicle CAR KA-01-DB-1234 black
//park_vehicle CAR KA-02-CB-1334 red
//park_vehicle CAR KA-01-DB-1133 black
//park_vehicle CAR KA-05-HJ-8432 white
//park_vehicle CAR WB-45-HO-9032 white
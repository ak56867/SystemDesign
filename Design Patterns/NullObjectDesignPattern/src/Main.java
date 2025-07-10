public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("Bike"); //if input is "Car" then we will get proper output
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        System.out.println("Tank Capacity: " + vehicle.getTankCapacity());
        System.out.println("Seat Capacity: " + vehicle.getSeatingCapacity());
    }
}
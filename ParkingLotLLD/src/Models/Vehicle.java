package Models;

public class Vehicle {
    public String reg_no;
    public VehicleType vehicleType;
    public String color;

    public Vehicle(String reg_no, VehicleType vehicleType, String color) {
        this.reg_no = reg_no;
        this.vehicleType = vehicleType;
        this.color = color;
    }
}

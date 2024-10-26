public class VehicleFactory {
    static Vehicle getVehicleObject(String typeOfVehicle) {
        if("Car".equalsIgnoreCase(typeOfVehicle)) {
            return new Car();
        }
        return new NullVehicle();
    }
}

package WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle{
    //overriding drive function
    public void drive(){
        System.out.println("Special Drive Capability"); //similar to SportsVehicle hence code duplication
    }
}

package WithoutStrategyPattern;

public class SportsVehicle extends Vehicle{
    //overriding drive function
    public void drive(){
        System.out.println("Special Drive Capability"); //similar to OffRoadVehicle hence code duplication
    }
}

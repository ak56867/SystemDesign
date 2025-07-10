package WithStrategyPattern.Strategy;

public class SpecialDriveStrategy implements DriveStrategy{
    public void drive(){
        System.out.println("Special Drive Strategy");
    }
}

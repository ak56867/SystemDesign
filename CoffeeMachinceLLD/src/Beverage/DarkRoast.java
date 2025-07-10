package Beverage;

public class DarkRoast extends Coffee{

    public DarkRoast() {
        name = "Dark Roast";
    }
    @Override
    public int cost() {
        return 180;
    }
}

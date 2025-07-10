package Beverage;

public class Espresso extends Coffee{
    public Espresso() {
        name = "Espresso";
    }

    @Override
    public int cost() {
        return 220;
    }
}

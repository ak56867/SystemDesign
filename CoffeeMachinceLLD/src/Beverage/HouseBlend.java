package Beverage;

public class HouseBlend extends Coffee{
    public HouseBlend() {
        name = "House Blend";
    }

    @Override
    public int cost() {
        return 200;
    }
}

package Beverage;

public class Decaf extends Coffee{
    public Decaf()  {
        name = "Decaf";
    }

    @Override
    public int cost() {
        return 150;
    }
}

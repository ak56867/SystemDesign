package Condiments;

import Beverage.Coffee;

public class Chocolate extends Extras{
    Coffee coffee;

    public Chocolate(Coffee coffee) {
        name = "Chocolate";
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return coffee.cost() + 50;
    }
}

package Condiments;

import Beverage.Coffee;

public class Milk extends Extras{
    Coffee coffee;

    public Milk(Coffee coffee) {
        name = "Milk";
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return coffee.cost() + 20;
    }
}

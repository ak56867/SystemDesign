package Condiments;

import Beverage.Coffee;

public class Mocha extends Extras{
    Coffee coffee;

    public Mocha(Coffee coffee) {
        name = "Mocha";
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return coffee.cost() + 70;
    }
}

package Condiments;

import Beverage.Coffee;

public class Soy extends Extras{
    Coffee coffee;

    public Soy(Coffee coffee) {
        name = "Soy";
        this.coffee = coffee;
    }

    @Override
    public int cost() {
        return coffee.cost() + 30;
    }
}

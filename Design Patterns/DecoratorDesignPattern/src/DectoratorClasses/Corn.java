package DectoratorClasses;

import baseClasses.BasePizza;

public class Corn extends ToppingsDecorator{
    BasePizza basePizza;

    public Corn(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 10;
    }
}

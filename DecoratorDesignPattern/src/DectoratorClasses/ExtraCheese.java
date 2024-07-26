package DectoratorClasses;

import baseClasses.BasePizza;

public class ExtraCheese extends  ToppingsDecorator{
    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza){ //getting the type of base pizza
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + 20; // adding 20 rs to the price of base pizza
    }
}

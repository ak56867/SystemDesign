import Beverage.Coffee;
import Beverage.Espresso;
import Beverage.HouseBlend;
import Condiments.Chocolate;
import Condiments.Milk;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Espresso();
        System.out.println(coffee.name + ": " + coffee.cost());

        Coffee coffee1 = new HouseBlend();
        coffee1 = new Chocolate(coffee1);
        coffee1 = new Milk(coffee1);
        System.out.println(coffee1.name + ": " + coffee1.cost());
    }
}
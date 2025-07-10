import DectoratorClasses.Corn;
import DectoratorClasses.ExtraCheese;
import baseClasses.BasePizza;
import baseClasses.VegDelight;

public class Main {
    public static void main(String[] args) {

        BasePizza pizza = new ExtraCheese(new Corn(new VegDelight())); //creating a pizza with base of VegDelight and extra cheese
        System.out.println(pizza.cost());
    }
}
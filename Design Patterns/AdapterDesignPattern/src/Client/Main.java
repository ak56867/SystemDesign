package Client;

import Adaptee.WeightInPoundsImpl;
import Adapter.WeightInKgs;
import Adapter.WeightInKgsImpl;

public class Main {
    public static void main(String[] args) {
        WeightInKgs weightInKgs = new WeightInKgsImpl(new WeightInPoundsImpl());
        System.out.println(weightInKgs.getWeightInKgs());
    }
}
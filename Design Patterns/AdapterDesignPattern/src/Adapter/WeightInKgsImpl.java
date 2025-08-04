package Adapter;

import Adaptee.WeightInPounds;

public class WeightInKgsImpl implements WeightInKgs{

    WeightInPounds weightInPounds;

    public WeightInKgsImpl(WeightInPounds weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    @Override
    public int getWeightInKgs() {
        return (int)(weightInPounds.getWeight() * 0.45);
    }
}

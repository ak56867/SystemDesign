package Models;

public class Dice {

    public int rollDice() {
        int min = 1;
        int max = 6;

        int diceVal = (int) (Math.random()*(max-min+1)) + min;
        return diceVal;
    }
}

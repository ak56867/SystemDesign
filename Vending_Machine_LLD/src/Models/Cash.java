package Models;

public enum Cash {
    TEN(10),
    FIFTY(50),
    HUNDRED(100);

    public int amount;

    Cash(int amount) {
        this.amount = amount;
    }
}

package Models;

public class BankAccount {
    int accountNumber;
    double balance;

    public void updateBalance(int amount)  {
        balance = balance - amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

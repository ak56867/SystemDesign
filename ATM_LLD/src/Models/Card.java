package Models;

public class Card {
    int cardNumber;
    int cvv;
    BankAccount bankAccount;

    public double getBankBalance() {
        return bankAccount.getBalance();
    }

    public boolean authenticatePin(int pin) {
        if(cvv == pin)  return true;
        return false;
    }

    public void deductBankBalance(int amount){
        bankAccount.updateBalance(amount);
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}

package States;

import AtmService.Atm;
import Models.Card;
import Models.TransactionType;

public abstract class AtmStates {
    public void insertCard(Atm atm, Card card) {
        System.out.println("oops!! something went wrong..");
    }

    public void validatePin(Atm atm, Card card, int pin) {
        System.out.println("oops!! something went wrong..");
    }

    public void selectOperation(Atm atm, Card card, TransactionType txn) {
        System.out.println("oops!! something went wrong..");
    }

    public void withdrawCash(Atm atm, Card card, int amount) {
        System.out.println("oops!! something went wrong..");
    }

    public void checkBalance(Atm atm, Card card) {
        System.out.println("oops!! something went wrong..");
    }

    public void returnCard() {
        System.out.println("oops!! something went wrong..");
    }

    public void exitAtm(Atm atm) {
        System.out.println("oops!! something went wrong..");
    }
}

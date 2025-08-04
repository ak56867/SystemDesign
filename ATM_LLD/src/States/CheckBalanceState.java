package States;

import AtmService.Atm;
import Models.Card;

public class CheckBalanceState extends AtmStates{

    public CheckBalanceState() {
        System.out.println("ATM in Check Balance State...");
    }

    @Override
    public void checkBalance(Atm atm, Card card) {
        System.out.println("Account balance: " + card.getBankBalance());
        exitAtm(atm);
    }

    public void exitAtm(Atm atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exited Atm");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card...");
    }
}

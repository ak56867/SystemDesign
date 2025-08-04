package States;

import AtmService.Atm;
import Models.Card;
import Models.TransactionType;

public class SelectOperationState extends AtmStates{

    public SelectOperationState() {
        System.out.println("ATM in Operation Selection State...");
    }

    @Override
    public void selectOperation(Atm atm, Card card, TransactionType txn) {
        switch (txn) {
            case CASH_WITHDRAWAL :
                atm.setAtmState(new CashWithdrawalState());
                break;
            case CHECK_BALANCE:
                atm.setAtmState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option!!");
                exitAtm(atm);
            }
        }
    }

    @Override
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

package States;

import AmountWithdrawal.TwoThousandWithdrawProcessor;
import AmountWithdrawal.WithdrawalProcessor;
import AtmService.Atm;
import Models.Card;

public class CashWithdrawalState extends AtmStates{

    public CashWithdrawalState() {
        System.out.println("ATM in Cash Withdrawal state...");
    }

    @Override
    public void withdrawCash(Atm atm, Card card, int amount) {
        if(amount > atm.getAtmBalance()) {
            System.out.println("ATM do not have required balance...");
            exitAtm(atm);
        } else if(amount > card.getBankBalance()) {
            System.out.println("Insufficient balance in your bank account...");
            exitAtm(atm);
        } else {
            card.deductBankBalance(amount);
            atm.updateAtmBalance(amount);

            WithdrawalProcessor withdrawalProcessor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
        }
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

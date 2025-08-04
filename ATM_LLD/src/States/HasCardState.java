package States;

import AtmService.Atm;
import Models.Card;

public class HasCardState extends AtmStates{

    public HasCardState() {
        System.out.println("ATM in Has Card State...");
    }

    @Override
    public void validatePin(Atm atm, Card card, int pin) {
        boolean validPin = card.authenticatePin(pin);
        if(validPin) {
            atm.setAtmState(new SelectOperationState());
        } else {
            System.out.println("Invalid Pin!!");
            exitAtm(atm);
        }
    }

    @Override
    public void exitAtm(Atm atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exited ATM");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card...");
    }
}

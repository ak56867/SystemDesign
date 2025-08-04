package States;

import AtmService.Atm;
import Models.Card;

public class IdleState extends AtmStates{

    public IdleState() {
        System.out.println("ATM in Idle State..");
    }

    @Override
    public void insertCard(Atm atm, Card card) {
        System.out.println("Card inserted!!");
        atm.setAtmState(new HasCardState());
    }
}

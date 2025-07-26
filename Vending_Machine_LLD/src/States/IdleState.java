package States;

import Models.Cash;
import Models.Item;
import Service.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements VendingMachineStates{
    public IdleState()  {
        System.out.println("Vending Machine in Idle state..");
    }

    @Override
    public void onClickAcceptCash(VendingMachine vendingMachine, Cash cash) throws Exception {
        vendingMachine.setVendingMachineStates(new HasMoneyState(vendingMachine, cash));
    }

    @Override
    public void onClickSelectProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("No money inserted!!");
    }

    @Override
    public Item onClickDispense(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("No product selected!!");
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        throw new Exception("No money inserted!!");
    }

    @Override
    public List<Cash> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("No money inserted!!");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        vendingMachine.getInventory().addInventory(item, code);
    }
}

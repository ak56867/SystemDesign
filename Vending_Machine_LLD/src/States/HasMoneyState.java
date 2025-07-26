package States;

import Models.Cash;
import Models.Item;
import Service.VendingMachine;

import java.util.List;

public class HasMoneyState implements VendingMachineStates{

    public HasMoneyState(VendingMachine vendingMachine, Cash cash) {
        System.out.println("Vending Machine in Has Money state..");

        try {
            onClickAcceptCash(vendingMachine, cash);
        }catch (Exception e) {

        }
    }

    @Override
    public void onClickAcceptCash(VendingMachine vendingMachine, Cash cash) throws Exception {
        vendingMachine.getCashList().add(cash);
        System.out.println(cash + " Rupees Cash accepted..");
    }

    @Override
    public void onClickSelectProduct(VendingMachine vendingMachine, int code) throws Exception {
        vendingMachine.setVendingMachineStates(new SelectProductState(vendingMachine, code));
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
        throw new Exception("Cannot update inventory during processing..");
    }
}

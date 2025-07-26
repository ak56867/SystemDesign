package States;

import Models.Cash;
import Models.Item;
import Service.VendingMachine;
import java.util.List;

public class SelectProductState implements VendingMachineStates{

    public SelectProductState(VendingMachine vendingMachine, int code) {
        System.out.println("Vending Machine in Select Product State..");

        try {
            onClickSelectProduct(vendingMachine, code);
        } catch (Exception e){

        }
    }

    @Override
    public void onClickAcceptCash(VendingMachine vendingMachine, Cash cash) throws Exception {
        throw new Exception("Cannot accept money now, please cancel and start again..");
    }

    @Override
    public void onClickSelectProduct(VendingMachine vendingMachine, int code) throws Exception {
        Item item = vendingMachine.getInventory().getItem(code);

        int amountPaid = 0;
        for(Cash cash: vendingMachine.getCashList()) {
            amountPaid += cash.amount;
        }

        if(amountPaid < item.getPrice()) {
            System.out.println("Insufficient money inserted, Item price: " + item.getPrice() + ", amount paid by you: " + amountPaid);
            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient amount");
        } else {
            if(amountPaid > item.getPrice()) {
                int refundValue = amountPaid - item.getPrice();
                getChange(refundValue);
            }
            vendingMachine.setVendingMachineStates(new DispenseState(vendingMachine, code));
        }
    }

    @Override
    public Item onClickDispense(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Cannot dispense product in Select state..");
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        return returnMoney;
    }

    @Override
    public List<Cash> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Refunding full amount..");
        vendingMachine.setVendingMachineStates(new IdleState());
        return vendingMachine.getCashList();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        throw new Exception("Cannot update inventory during processing..");
    }
}

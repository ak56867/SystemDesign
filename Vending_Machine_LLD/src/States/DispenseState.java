package States;

import Models.Cash;
import Models.Item;
import Service.VendingMachine;

import java.util.List;

public class DispenseState implements VendingMachineStates{

    public DispenseState(VendingMachine vendingMachine, int code) {
        System.out.println("Vending Machine in dispense state..");

        try {
            onClickDispense(vendingMachine, code);
        } catch (Exception e) {

        }
    }

    @Override
    public void onClickAcceptCash(VendingMachine vendingMachine, Cash cash) throws Exception {
        throw new Exception("Cannot accept money now, please cancel and start again..");
    }

    @Override
    public void onClickSelectProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("Cannot select product now, please cancel and start again..");
    }

    @Override
    public Item onClickDispense(VendingMachine vendingMachine, int code) throws Exception {
        Item item = vendingMachine.getInventory().getItem(code);
        vendingMachine.getInventory().updateSoldOutItem(code);
        vendingMachine.setVendingMachineStates(new IdleState());
        System.out.println(item.getItemType() + "Dispensed..");
        return item;
    }

    @Override
    public int getChange(int returnMoney) throws Exception {
        throw new Exception("Change cannot be returned during dispensing..");
    }

    @Override
    public List<Cash> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot refund during dispensing..");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        throw new Exception("Cannot update inventory during processing..");
    }
}

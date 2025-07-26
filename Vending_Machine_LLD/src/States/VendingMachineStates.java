package States;

import Models.Cash;
import Models.Item;
import Models.ItemType;
import Service.VendingMachine;

import java.util.List;

public interface VendingMachineStates {
    void onClickAcceptCash(VendingMachine vendingMachine, Cash cash) throws Exception;
    void onClickSelectProduct(VendingMachine vendingMachine, int code) throws Exception;
    Item onClickDispense(VendingMachine vendingMachine, int code) throws Exception;
    int getChange(int returnMoney) throws Exception;
    List<Cash> refundFullMoney(VendingMachine vendingMachine) throws Exception;
    void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception;
}

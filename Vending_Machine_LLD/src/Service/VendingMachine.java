package Service;

import Models.Cash;
import States.IdleState;
import States.VendingMachineStates;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    VendingMachineStates vendingMachineStates;
    Inventory inventory;
    List<Cash> cashList;

    public VendingMachine() {
        vendingMachineStates = new IdleState();
        inventory = new Inventory(10);
        cashList = new ArrayList<>();
    }

    public VendingMachineStates getVendingMachineStates() {
        return vendingMachineStates;
    }

    public void setVendingMachineStates(VendingMachineStates vendingMachineStates) {
        this.vendingMachineStates = vendingMachineStates;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public List<Cash> getCashList() {
        return cashList;
    }

    public void setCashList(List<Cash> cashList) {
        this.cashList = cashList;
    }
}

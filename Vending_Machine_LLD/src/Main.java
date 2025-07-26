import Models.Cash;
import Models.Item;
import Models.ItemType;
import Service.ItemShelf;
import Service.VendingMachine;
import States.VendingMachineStates;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        fillUp(vendingMachine);
        displayInventory(vendingMachine);

        try {

            System.out.println("User clicks on Insert cash button..");

            VendingMachineStates vendingMachineStates = vendingMachine.getVendingMachineStates();
            vendingMachineStates.onClickAcceptCash(vendingMachine, Cash.HUNDRED);
            vendingMachineStates.onClickAcceptCash(vendingMachine, Cash.HUNDRED);

            System.out.println("User clicks on Product selection button..");
            vendingMachineStates = vendingMachine.getVendingMachineStates();
            vendingMachineStates.onClickSelectProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        }catch (Exception e) {

        }
    }

    private static void fillUp(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i=0;i<slots.length;i++) {
            Item item = new Item();
            if(i>=0 && i<3) {
                item.setItemType(ItemType.COKE);
                item.setPrice(150);
            } else if(i>=3 && i<6) {
                item.setItemType(ItemType.WATER);
                item.setPrice(100);
            } else {
                item.setItemType(ItemType.JUICE);
                item.setPrice(120);
            }
            slots[i].setItem(item);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for(ItemShelf itemShelf: slots) {
            System.out.println(
                    "Code: " + itemShelf.getCode()
                    + " Name: " + itemShelf.getItem().getItemType()
                    + " Price: " + itemShelf.getItem().getPrice()
                    + " Available? "  + !itemShelf.isSoldOut()
            );
        }
    }
}
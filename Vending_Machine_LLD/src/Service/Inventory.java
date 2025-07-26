package Service;

import Models.Item;

public class Inventory {
    ItemShelf[] inventory = null;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        setupItemSlots();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    void setupItemSlots() {
        int startCode = 101;
        for(int i=0;i<inventory.length;i++) {
            ItemShelf space = new ItemShelf();
            space.setCode(startCode++);
            space.setSoldOut(true);
            inventory[i] = space;
        }
    }

    public void addInventory(Item item, int code) throws Exception{
        for(ItemShelf itemShelf: inventory)  {
            if(itemShelf.code == code) {
                if(itemShelf.isSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("Item already available, Cannot add item here.");
                }
            }
        }
    }

    public Item getItem(int code) throws Exception{
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.code == code) {
                if(itemShelf.isSoldOut()) {
                    System.out.println("Item Sold Out!!");
                } else {
                    return itemShelf.getItem();
                }
            }
        }
        throw new Exception("Invalid Code!!");
    }

    public void updateSoldOutItem(int code) throws Exception{
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.code == code) {
                itemShelf.setSoldOut(true);
            }
        }
        throw new Exception("Invalid Code!!");
    }
}

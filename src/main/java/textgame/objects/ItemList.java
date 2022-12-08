package textgame.objects;

import java.util.ArrayList;

public class ItemList extends ArrayList<Item> {

    public String toString() {
        String desc = "";
        if (this.size() > 0) {
            int itemsCount = 1;
            for (Item i : this) {
                if (itemsCount == this.size()) {
                    desc += i.toString();
                } else {
                    desc += i.toString() + "\n";
                }
                itemsCount++;
            }
        }
        return desc;
    }

    public Item thisObject(String itemName) {
        Item item = null;
        String itemN = "";
        String itemNameLowerCase = itemName.trim().toLowerCase();
        for (Item it : this) {
            itemN = it.getName().trim().toLowerCase();
            if (itemN.equals(itemNameLowerCase)) {
                item = it;
            }
        }
        return item;
    }

}

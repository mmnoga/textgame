package textgame.objects;

import java.util.ArrayList;

public class ItemList extends ArrayList<Item> {
    public String toString() {
        String desc = "";
        if (this.size() > 0) {
            for (Item i : this) {
                desc += i.toString() + "\n";
            }
        }
        return desc;
    }
}

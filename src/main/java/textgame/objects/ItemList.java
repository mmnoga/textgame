package textgame.objects;

import java.util.ArrayList;

public class ItemList extends ArrayList<Item> {
    public String toString() {
        String desc = "";
        if (this.size() > 0) {
            if (this.size() == 1) {
                desc += this.get(0).toString();
            } else {
                for (Item i : this) {
                    desc += i.toString() + "\n";
                }
            }
        }
        return desc;
    }
}

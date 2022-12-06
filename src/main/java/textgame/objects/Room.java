package textgame.objects;

public class Room extends Container {

    public Room(String name, String description, ItemList items) {
        super(name, description, items);
    }

    public String toString() {
        String desc = "";
        desc = getName() + " (" + getDescription() + ")" + "\n";
        desc += "items inside:\n";
        desc += getItems().toString();
        return desc;
    }
}

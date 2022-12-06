package textgame.objects;

public class Player extends Container {
    private Room room;

    public Player(String name, String description,
                  ItemList items,
                  Room room) {
        super(name, description, items);
        this.room = room;
    }

    public Room getPosition() {
        return room;
    }

    public String toString() {
        String desc = "";
        desc = getName() + " (" + getDescription() + ")" + "\n";
        desc += "equipment:\n";
        if (!getItems().isEmpty()) {
            desc += getItems().toString();
        } else {
            desc += "no items";
        }
        return desc;
    }

}

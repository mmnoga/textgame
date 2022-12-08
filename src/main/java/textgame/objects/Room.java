package textgame.objects;

public class Room extends Container {

    Room(String name, String description, boolean isVisible, boolean canBeTaken, ItemList items) {
        super(name, description, isVisible, canBeTaken, items);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Container.Builder<Builder> {
        @Override
        public Room build() {
            return new Room(name, description, isVisible, canBeTaken, items);
        }
    }

    public String toString() {
        String desc = "";
        desc = getName().toUpperCase() + " (" + getDescription() + ")" + "\n";
        desc += "items inside:\n";
        if (getItems() != null) {
            desc += getItems().toString();
        } else {
            desc += "no items";
        }
        return desc;
    }

}

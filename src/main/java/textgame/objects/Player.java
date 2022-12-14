package textgame.objects;

public class Player extends Container {
    private Room room;

    Player(String name, String description,
           boolean isVisible, boolean canBeTaken,
           ItemList items,
           Room room) {
        super(name, description, isVisible, canBeTaken, items);
        this.room = room;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Container.Builder<Builder> {
        private Room room;

        public Builder room(Room room) {
            this.room = room;
            return this;
        }

        @Override
        public Player build() {
            return new Player(name, description,
                    isVisible, canBeTaken,
                    items,
                    room);
        }
    }

    public Room getPosition() {
        return room;
    }

    public String toString() {
        String desc = "";
        desc = "You're " + getName().toUpperCase() + " - " + getDescription() + "\n";
        desc += "Your equipment:\n";
        if (getItems() != null) {
            desc += getItems().toString();
        } else {
            desc += "no items";
        }
        return desc;
    }

}

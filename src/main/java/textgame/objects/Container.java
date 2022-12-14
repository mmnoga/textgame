package textgame.objects;

public class Container extends Item {
    private ItemList items = new ItemList();

    Container(String name, String description, boolean isVisible, boolean canBeTaken,
              ItemList items) {
        super(name, description, isVisible, canBeTaken);
        this.items = items;
    }

    public static Builder<? extends Builder> builder() {
        return new Builder<>();
    }

    public static class Builder<S extends Builder<S>> extends Item.Builder<S> {
        protected ItemList items;

        Builder() {
        }

        public S items(ItemList items) {
            this.items = items;
            return (S) this;
        }

        @Override
        public Container build() {
            return new Container(name, description, isVisible, canBeTaken, items);
        }
    }

    public ItemList getItems() {
        return items;
    }

    public void setItems(ItemList items) {
        this.items = items;
    }

    public String toString() {
        String desc = "";
        if (isVisible()) {
            desc = getName().toUpperCase() + " (" + getDescription() + ")";
            if (canBeTaken()) {
                desc += "\n\tit can be taken";
            } else {
                desc += "\n\tit can't be taken";
            }
            if (getItems().size() > 0 ) {
                desc += "\n\titems on the " + getName() + ":";
                desc += "\n\t" + getItems().toString();
            } else {
                desc += "\n\tthere's no items on the " + getName();
            }
        }
        return desc;
    }

}

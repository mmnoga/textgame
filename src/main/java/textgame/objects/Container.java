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
            desc = getName() + " (" + getDescription() + ")";
            if (canBeTaken()) {
                desc += "\n";
                desc += "it can be taken";
            } else {
                desc += "it can't be taken";
            }
            if (getItems() != null) {
                desc += "\nitems on the " + getName() + ":";
                desc += "\n" + getItems().toString();
            } else {
                desc += "there's no items on the " + getName();
            }
        } else {
            desc = "there's no item";
        }
        return desc;
    }

}

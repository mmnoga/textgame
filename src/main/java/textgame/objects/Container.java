package textgame.objects;

public class Container extends Item {
    private ItemList items = new ItemList();

    public Container(String name, String description, ItemList items) {
        super(name, description);
        this.items = items;
    }

    public Container(String name, String description,
                     boolean isVisible, boolean canBeTaken,
                     ItemList items) {
        super(name, description, isVisible, canBeTaken);
        this.items = items;
    }

    public ItemList getItems() {
        return items;
    }

    public void setItems(ItemList items) {
        this.items = items;
    }

}

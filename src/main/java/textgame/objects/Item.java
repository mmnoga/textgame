package textgame.objects;

public class Item extends ObjectBase {
    private boolean isVisible;
    private boolean canBeTaken;

    public Item(String name, String description) {
        super(name, description);
    }

    public Item(String name, String description,
                boolean isVisible, boolean canBeTaken) {
        super(name, description);
        this.isVisible = isVisible;
        this.canBeTaken = canBeTaken;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void isVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean canBeTaken() {
        return canBeTaken;
    }

    public void canBeTaken(boolean canBeTaken) {
        this.canBeTaken = canBeTaken;
    }

}

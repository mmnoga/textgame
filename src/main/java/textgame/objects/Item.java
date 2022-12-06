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

    public void hide() {
        this.isVisible = false;
    }

    public void show() {
        this.isVisible = true;
    }

    public boolean canBeTaken() {
        return canBeTaken;
    }

    public void canBeTaken(boolean canBeTaken) {
        this.canBeTaken = canBeTaken;
    }

    public String toString() {
        String desc = "";
        if (isVisible) {
            desc = super.toString() + "\n";
            if (canBeTaken) {
                desc += "it can be taken";
            } else {
                desc += "it can't be taken";
            }
        } else {
            desc = "there's no item";
        }
        return desc;
    }

}
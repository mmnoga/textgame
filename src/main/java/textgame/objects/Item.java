package textgame.objects;

public class Item extends ObjectBase {
    private boolean isVisible;
    private boolean canBeTaken;

    Item(String name, String description,
         boolean isVisible, boolean canBeTaken) {
        super(name, description);
        this.isVisible = isVisible;
        this.canBeTaken = canBeTaken;
    }

    public static Builder<? extends Builder> builder() {
        return new Builder<>();
    }

    public static class Builder<S extends Builder<S>> extends ObjectBase.Builder<S> {
        protected boolean isVisible;
        protected boolean canBeTaken;

        Builder() {
        }

        public S isVisible(boolean isVisible) {
            this.isVisible = isVisible;
            return (S) this;
        }

        public S canBeTaken(boolean canBeTaken) {
            this.canBeTaken = canBeTaken;
            return (S) this;
        }

        @Override
        public Item build() {
            return new Item(name, description, isVisible, canBeTaken);
        }
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

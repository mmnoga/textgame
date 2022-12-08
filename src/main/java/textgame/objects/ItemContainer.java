package textgame.objects;

public class ItemContainer extends Container {
    private boolean isOpen;
    private boolean canBeOpen;

    ItemContainer(String name, String description,
                  boolean isVisible, boolean canBeTaken,
                  ItemList items,
                  boolean isOpen, boolean canBeOpen) {
        super(name, description, isVisible, canBeTaken, items);
        this.isOpen = isOpen;
        this.canBeOpen = canBeOpen;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends Container.Builder<Builder> {
        private boolean isOpen;
        private boolean canBeOpen;

        public Builder isOpen(boolean isOpen) {
            this.isOpen = isOpen;
            return this;
        }

        public Builder canBeOpen(boolean canBeOpen) {
            this.canBeOpen = canBeOpen;
            return this;
        }

        @Override
        public ItemContainer build() {
            return new ItemContainer(name, description, isVisible, canBeTaken, items, isOpen, canBeOpen);
        }
    }

    public String open() {
        if (isVisible()) {
            if (canBeOpen) {
                if (isOpen) {
                    return "it's already open";
                } else {
                    isOpen = true;
                    return "it's been opened";
                }
            } else {
                return "it can't be open";
            }
        } else {
            return "there's no item";
        }
    }

    public String close() {
        if (isVisible()) {
            if (canBeOpen) {
                if (!isOpen) {
                    return "it's already close";
                } else {
                    isOpen = false;
                    return "it's been closed";
                }
            } else {
                return "it can't be closed";
            }
        } else {
            return "there's no item";
        }
    }

    public String toString() {
        String desc = "";
        if (isVisible()) {
            desc = getName().toUpperCase() + " (" + getDescription() + ")" + "\n";
            if (canBeTaken()) {
                desc += "\tit can be taken";
            } else {
                desc += "\tit can't be taken";
            }
            if (canBeOpen) {
                desc += "\n";
                if (isOpen) {
                    desc += "\tit's open";
                    if (getItems() != null) {
                        desc += "\n\titems inside:";
                        if (!getItems().isEmpty()) {
                            desc += "\n\t" + getItems().toString();
                        } else {
                            desc += "\n\t" + "no items";
                        }
                    } else {
                        desc += "\n\tit's empty";
                    }
                } else {
                    desc += "\tit's closed";
                }
            }
        }
        return desc;
    }

}

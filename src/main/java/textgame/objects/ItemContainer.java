package textgame.objects;

public class ItemContainer extends Container {
    private boolean isOpen;
    private boolean canBeOpen;

    public ItemContainer(String name, String description,
                         ItemList items) {
        super(name, description, items);
        isOpen = true;
        canBeOpen = false;
    }

    public ItemContainer(String name, String description,
                         boolean isVisible, boolean canBeTaken,
                         ItemList items) {
        super(name, description, isVisible, canBeTaken, items);
        isOpen = true;
        canBeOpen = false;
    }

    public ItemContainer(String name, String description,
                         boolean isVisible, boolean canBeTaken,
                         boolean isOpen, boolean canBeOpen,
                         ItemList items) {
        super(name, description, isVisible, canBeTaken, items);
        this.isOpen = isOpen;
        this.canBeOpen = canBeOpen;
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
            desc = getName() + " (" + getDescription() + ")" + "\n";
            if (canBeTaken()) {
                desc += "it can be taken";
            } else {
                desc += "it can't be taken";
            }
            if (canBeOpen) {
                desc += "\n";
                if (isOpen) {
                    desc += "it's open";
                    if (!getItems().isEmpty()) {
                        desc += "\nitems inside:";
                        desc += "\n" + getItems().toString();
                    } else {
                        desc += "\nit's empty";
                    }
                } else {
                    desc += "it's closed";
                }
            }
        } else {
            desc = "there's no item";
        }

        return desc;
    }

}

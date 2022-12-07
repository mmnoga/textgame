package textgame.objects;

public class Device extends Item {
    private boolean isSwitch;
    private boolean canBeSwitch;

    Device(String name, String description,
           boolean isVisible, boolean canBeTaken,
           boolean isSwitch, boolean canBeSwitch) {
        super(name, description, isVisible, canBeTaken);
        this.isSwitch = isSwitch;
        this.canBeSwitch = canBeSwitch;
    }

    public static Builder<? extends Builder> builder() {
        return new Builder<>();
    }

    public static class Builder<S extends Builder<S>> extends Item.Builder<S> {
        protected boolean isSwitch;
        protected boolean canBeSwitch;

        Builder() {
        }

        public S isSwitch(boolean isSwitch) {
            this.isSwitch = isSwitch;
            return (S) this;
        }

        public S canBeSwitch(boolean canBeSwitch) {
            this.canBeSwitch = canBeSwitch;
            return (S) this;
        }

        @Override
        public Device build() {
            return new Device(name, description, isVisible, canBeTaken, isSwitch, canBeSwitch);
        }
    }

    public boolean isSwitch() {
        return isSwitch;
    }

    public String turnOn() {
        if (isVisible()) {
            if (canBeSwitch) {
                if (isSwitch) {
                    return "it's already turned on";
                } else {
                    isSwitch = true;
                    return "it's been turned on";
                }
            } else {
                return "can not be turned on";
            }
        } else {
            return "there's no device";
        }
    }

    public String turnOff() {
        if (isVisible()) {
            if (canBeSwitch) {
                if (!isSwitch) {
                    return "it's already turned off";
                } else {
                    isSwitch = false;
                    return "it's been turned off";
                }
            } else {
                return "can not be turned off";
            }
        } else {
            return "there's no device";
        }
    }

    public boolean canBeSwitch() {
        return canBeSwitch;
    }

    public void canBeSwitch(boolean canBeSwitch) {
        this.canBeSwitch = canBeSwitch;
    }

    public String toString() {
        String desc = "";
        desc = getName() + " (" + getDescription() + ")" + "\n";
        if (isSwitch) {
            desc += "it's switch on";
        } else {
            desc += "it's switch off";
        }
        return desc;
    }

}

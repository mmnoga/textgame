package textgame.objects;

public class Device extends Item {
    private boolean isSwitch;
    private boolean canBeSwitch;

    public Device(String name, String description) {
        super(name, description);
    }

    public Device(String name, String description,
                  boolean isVisible, boolean canBeTaken) {
        super(name, description, isVisible, canBeTaken);
    }

    public Device(String name, String description,
                  boolean isVisible, boolean canBeTaken,
                  boolean isSwitch, boolean canBeSwitch) {
        super(name, description, isVisible, canBeTaken);
        this.isSwitch = isSwitch;
        this.canBeSwitch = canBeSwitch;
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

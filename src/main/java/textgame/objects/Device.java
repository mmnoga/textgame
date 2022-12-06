package textgame.objects;

public class Device extends Item{
    private boolean isSwitch;
    private boolean canBeSwitch;

    public Device(String name, String description) {
        super(name, description);
    }

    public Device(String name, String description,
                  boolean isVisible, boolean canBeTaken){
        super(name, description, isVisible, canBeTaken);
    }

    public Device(String name, String description,
                  boolean isVisible, boolean canBeTaken,
                  boolean isSwitch, boolean canBeSwitch){
        super(name, description, isVisible, canBeTaken);
        this.isSwitch = isSwitch;
        this.canBeSwitch = canBeSwitch;
    }

    public boolean isSwitch(){
        return isSwitch;
    }

    public void turnOn(){
        this.isSwitch = true;
    }

    public void turnOff(){
        this.isSwitch = false;
    }

    public boolean canBeSwitch(){
        return canBeSwitch;
    }

    public void canBeSwitch(boolean canBeSwitch){
        this.canBeSwitch = canBeSwitch;
    }

}

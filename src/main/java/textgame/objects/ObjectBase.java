package textgame.objects;

public class ObjectBase {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return name + " (" + description + ")";
    }
}

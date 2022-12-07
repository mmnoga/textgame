package textgame.objects;

public class ObjectBase {
    private String name;
    private String description;

    ObjectBase(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<S extends Builder> {
        protected String name;
        protected String description;

        Builder() {
        }

        public S name(String name) {
            this.name = name;
            return (S) this;
        }

        public S description(String description) {
            this.description = description;
            return (S) this;
        }

        public ObjectBase build() {
            return new ObjectBase(name, description);
        }
    }


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

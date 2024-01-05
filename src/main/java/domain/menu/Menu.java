package domain.menu;

public class Menu {
    private final String name;
    private final String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

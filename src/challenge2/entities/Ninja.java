package challenge2.entities;

public class Ninja {
    String name;

    public Ninja(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ninja: {" +
                "name = '" + name + '\'' +
                '}';
    }
}

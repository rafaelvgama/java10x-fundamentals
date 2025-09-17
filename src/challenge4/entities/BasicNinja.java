package challenge4.entities;

import challenge4.enums.AbilityType;
import challenge4.interfaces.Ninja;

public class BasicNinja implements Ninja {
    protected String name;
    protected int age;
    protected AbilityType ability;

    public BasicNinja(String name, int age, AbilityType ability) {
        this.name = name;
        this.age = age;
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void performAbility() {
        System.out.printf("%s performed the ability %s.%n%n", this.name, this.ability);
    }

    @Override
    public String toString() {
        return "BasicNinja : {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", ability = " + ability +
                '}';
    }
}

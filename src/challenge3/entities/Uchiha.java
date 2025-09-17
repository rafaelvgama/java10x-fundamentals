package challenge3.entities;

public class Uchiha extends Ninja {
    private String specialAbility;

    public Uchiha(String name, int age, String specialAbility) {
        super(name, age);
        this.specialAbility = specialAbility;
    }

    public String getSpecialAbility() {
        return this.specialAbility;
    }

    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }

    @Override
    public String toString() {
        String missionName = this.mission != null ? this.mission.getName() : "No mission assigned";
        return "Uchiha: {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", special ability = " + specialAbility +
                ", mission = " + missionName +
                '}';
    }
}

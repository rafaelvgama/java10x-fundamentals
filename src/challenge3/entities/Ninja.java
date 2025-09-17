package challenge3.entities;

import challenge3.interfaces.HasName;

public class Ninja implements HasName {
    protected String name;
    protected int age;
    protected Mission mission;

    public Ninja(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }

    public void removeMission() {
        if (this.mission != null) {
            this.mission.setNinja(null);
            this.mission = null;
        }
    }

    @Override
    public String toString() {
        String missionName = this.mission != null ? this.mission.getName() : "No mission assigned";
        return "Ninja: {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", mission = " + missionName +
                '}';
    }

}

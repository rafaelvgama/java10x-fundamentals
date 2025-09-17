package challenge1.entities;

import challenge1.enums.MissionStatus;
import challenge1.enums.MissionRank;

public class Ninja {
    private String name;
    private int age;
    private Mission mission;

    public Ninja(String name, int age, Mission mission) {
        this.name = name;
        this.age = age;
        setMission(mission);
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

    public Mission getMission() {
        return mission;
    }

    public void setMission(Mission mission) {
        this.mission = mission;
        if (this.age >= 15
                || (mission.getRank().equals(MissionRank.C) || mission.getRank().equals(MissionRank.D))) {
            mission.setStatus(MissionStatus.FINISHED);
        } else {
            mission.setStatus(MissionStatus.CANCELED);
        }
    }

    @Override
    public String toString() {
        return "Ninja: {" +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", mission = " + mission.getName() +
                ", mission rank = " + mission.getRank() +
                ", mission status= " + mission.getStatus() +
                '}';
    }
}

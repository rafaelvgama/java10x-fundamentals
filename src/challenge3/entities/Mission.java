package challenge3.entities;

import challenge3.enums.MissionStatus;
import challenge3.enums.MissionRank;
import challenge3.interfaces.HasName;

public class Mission implements HasName {
    private String name;
    private MissionRank rank;
    private MissionStatus status;
    private Ninja ninja;

    public Mission(String name, MissionRank rank) {
        this.name = name;
        this.rank = rank;
        setStatus(MissionStatus.NEW);
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    public MissionRank getRank() {
        return rank;
    }

    public void setRank(MissionRank rank) {
        this.rank = rank;
    }

    public MissionStatus getStatus() {
        return status;
    }

    public void setStatus(MissionStatus status) {
        this.status = status;
    }

    public Ninja getNinja() {
        return ninja;
    }

    public void setNinja(Ninja ninja) {
        this.ninja = ninja;
    }

    @Override
    public String toString() {
        String ninjaName = this.ninja != null ? this.ninja.getName() : "No ninja assigned";
        return "Mission: {" +
                "name = '" + name + '\'' +
                ", rank = " + rank +
                ", status = " + status +
                ", ninja = " + ninjaName +
                '}';
    }
}

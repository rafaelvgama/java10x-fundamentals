package challenge1.entities;

import challenge1.enums.MissionRank;
import challenge1.enums.MissionStatus;

public class Mission {
    private String name;
    private MissionRank rank;
    private MissionStatus status;

    public Mission(String name, MissionRank rank) {
        this.name = name;
        this.rank = rank;
        setStatus(MissionStatus.NEW);
    }

    public String getName() {
        return name;
    }

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
}

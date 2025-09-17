package challenge1;

import challenge1.entities.Mission;
import challenge1.entities.Ninja;
import challenge1.enums.MissionRank;

import java.util.ArrayList;
import java.util.List;

public class Challenge1 {
    public static void main(String[] args) {

        List<Mission> missionList = new ArrayList<>();
        missionList.add(new Mission("Crimson Dawn", MissionRank.C));
        missionList.add(new Mission("Ghost Walk", MissionRank.A));
        missionList.add(new Mission("Hidden Fang", MissionRank.S));


        List<Ninja> ninjaList = new ArrayList<>();
        ninjaList.add(new Ninja("Naruto",12, missionList.get(0)));
        ninjaList.add(new Ninja("Sasuke",14, missionList.get(1)));
        ninjaList.add(new Ninja("Tsunade",25, missionList.get(2)));

        for (Ninja ninja : ninjaList) {
            System.out.println(ninja);
        }
    }
}

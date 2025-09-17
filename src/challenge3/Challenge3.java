package challenge3;

import challenge3.entities.Mission;
import challenge3.entities.Ninja;
import challenge3.utils.NinjaUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Ninja> ninjasList = new ArrayList<>();

        List<Mission> missionsList = new ArrayList<>();

        NinjaUtils.createMenu(sc, ninjasList, missionsList);

        sc.close();
    }
}

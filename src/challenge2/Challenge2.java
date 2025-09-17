package challenge2;

import challenge2.entities.Ninja;
import challenge2.utils.NinjaUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Challenge2 {
    public static void main(String[] args) {
        List<Ninja> ninjaList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        NinjaUtils.createMenu(sc, ninjaList);

        sc.close();
    }
}

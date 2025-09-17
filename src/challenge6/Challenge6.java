package challenge6;

import challenge6.entities.Ninja;
import challenge6.utils.NinjaUtils;

import java.util.LinkedList;
import java.util.Scanner;

public class Challenge6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<Ninja> ninjasList = new LinkedList<>();

        NinjaUtils.createMenu(ninjasList, sc);

        sc.close();
    }
}

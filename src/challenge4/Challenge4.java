package challenge4;

import challenge4.entities.AdvancedNinja;
import challenge4.entities.BasicNinja;
import challenge4.enums.AbilityType;

import java.util.Scanner;

public class Challenge4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BasicNinja ninja1 = new BasicNinja(
                "Rock Lee",
                15,
                AbilityType.TAIJUTSU);

        AdvancedNinja ninja2 = new AdvancedNinja(
                "Naruto",
                15,
                AbilityType.NINJUTSU,
                "Rasenshuriken");

        System.out.println(ninja1);
        ninja1.performAbility();

        System.out.println(ninja2);
        ninja2.performAbility();
        sc.close();

    }
}

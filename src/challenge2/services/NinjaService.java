package challenge2.services;

import challenge2.entities.Ninja;

import java.util.List;
import java.util.Scanner;

public final class NinjaService {
    private NinjaService() {
    }

    public static void createNinja(Scanner sc, List<Ninja> ninjaList) {
        System.out.println("Create Ninja");
        String ninjaName = readNonEmptyLine(sc, "Enter ninja's name: ");

        if (!alreadyExists(ninjaList, ninjaName)) {
            ninjaList.add(new Ninja(ninjaName));
        } else {
            System.out.printf("Ninja '%s' already exists.%n", ninjaName);
        }
    }

    public static void listNinjas(List<Ninja> ninjaList) {
        if (ninjaList.isEmpty()) {
            System.out.println("Empty list.");
        } else {
            System.out.println("Listing ninjas");
            for (Ninja ninja : ninjaList) {
                System.out.println(ninja);
            }
        }
    }

    public static boolean alreadyExists(List<Ninja> ninjaList, String name) {
        for (Ninja ninja : ninjaList) {
            if (ninja.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static String readNonEmptyLine(Scanner sc, String prompt) {
        String input = "";
        while (input.isEmpty()){
            System.out.print(prompt);
            input = sc.nextLine().trim();
        }
        return input;
    }
}

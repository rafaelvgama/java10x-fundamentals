package challenge6.services;

import challenge6.entities.Ninja;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public final class NinjaService {
    private NinjaService() {
    }

    public static void addNinja(LinkedList<Ninja> ninjasList, Scanner sc) {
        System.out.println("Adding:");
        String ninjaName = readNonEmptyString(sc, "Enter ninja's name: ");

        int ninjaAge;
        while (true) {
            ninjaAge = readValidInt(sc, "Enter ninja's age: ");
            if (ninjaAge < 0) {
                System.out.println("Invalid age.");
            } else {
                break;
            }
        }

        String ninjaVillage = readNonEmptyString(sc, "Enter the ninja's village: ");

        ninjasList.add(new Ninja(ninjaName, ninjaAge, ninjaVillage));
    }

    public static void orderedList(LinkedList<Ninja> ninjasList, Scanner sc) {
        System.out.println("Ordered list");
        if (ninjasList != null && !ninjasList.isEmpty()) {
            while (true) {
                String option = readNonEmptyString(sc,
                        "Search ninja by 'name', 'age' or 'village' (or 'exit' to skip): ");

                switch (option.toLowerCase()) {
                    case "name":
                        ninjasList.sort(Comparator.comparing(Ninja::getName));
                        listNinjas(ninjasList);
                        return;
                    case "age":
                        ninjasList.sort(Comparator.comparing(Ninja::getAge));
                        listNinjas(ninjasList);
                        return;
                    case "village":
                        ninjasList.sort(Comparator.comparing(Ninja::getVillage));
                        listNinjas(ninjasList);
                        return;
                    case "exit":
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Empty list.");
        }
    }

    public static void removeNinja(LinkedList<Ninja> ninjasList, Scanner sc) {
        System.out.println("Removing ninja");
        if (ninjasList != null && !ninjasList.isEmpty()) {
            String ninjaName = readNonEmptyString(sc, "Enter ninja's name to remove: ");
            Ninja ninja = findNinjaByName(ninjasList, ninjaName);
            if (ninja != null) {
                ninjasList.remove(ninja);
                System.out.println("Ninja removed: " + ninja);
            } else {
                System.out.println("Ninja not found.");
            }
        } else {
            System.out.println("Empty list.");
        }
    }

    public static void searchNinjaByName(LinkedList<Ninja> ninjasList, Scanner sc) {
        System.out.println("Search for ninja");
        if (ninjasList != null && !ninjasList.isEmpty()) {
            String ninjaName = readNonEmptyString(sc, "Enter ninja's name to search for: ");
            Ninja ninja = findNinjaByName(ninjasList, ninjaName);
            if (ninja != null) {
                System.out.println(ninja);
            } else {
                System.out.println("Ninja not found.");
            }
        } else {
            System.out.println("Empty list.");
        }
    }

    public static Ninja findNinjaByName(LinkedList<Ninja> ninjasList, String ninjaName) {
        for (Ninja ninja : ninjasList) {
            if (ninja.getName().equals(ninjaName)) {
                return ninja;
            }
        }
        return null;
    }

    public static void listNinjas(LinkedList<Ninja> ninjasList) {
        for (Ninja ninja : ninjasList) {
            System.out.println(ninja);
        }
    }

    public static String readNonEmptyString(Scanner sc, String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
        }
        return input;
    }

    public static int readValidInt(Scanner sc, String prompt) {
        while (true) {
            String input = readNonEmptyString(sc, prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid value.");
            }
        }
    }
}

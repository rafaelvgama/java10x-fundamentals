package challenge6.utils;

import challenge6.entities.Ninja;
import challenge6.services.NinjaService;

import java.util.LinkedList;
import java.util.Scanner;

public final class NinjaUtils {
    private NinjaUtils() {
    }

    public static void createMenu(LinkedList<Ninja> ninjasList, Scanner sc) {
        String option = "0";
        while (!option.equals("5")) {
            System.out.println("""
                    
                    ========= Ninja Menu =========
                    1. Add ninja
                    2. Ninjas ordered list
                    3. Remove ninja
                    4. Search ninja by name
                    5. Close
                    ==============================
                    """);

            option = NinjaService.readNonEmptyString(sc, "Choose an option: ");

            switch (option) {
                case "1":
                    NinjaService.addNinja(ninjasList, sc);
                    break;

                case "2":
                    NinjaService.orderedList(ninjasList, sc);
                    break;

                case "3":
                    NinjaService.removeNinja(ninjasList, sc);
                    break;

                case "4":
                    NinjaService.searchNinjaByName(ninjasList, sc);
                    break;

                case "5":
                    System.out.println("Closing program...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    option = "0";
            }
        }
    }
}

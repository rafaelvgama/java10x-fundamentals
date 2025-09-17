package challenge2.utils;

import challenge2.entities.Ninja;
import challenge2.services.NinjaService;

import java.util.List;
import java.util.Scanner;

public final class NinjaUtils {
    private NinjaUtils() {
    }

    public static void createMenu(Scanner sc, List<Ninja> ninjaList) {
        String option = "0";
        while (!option.equals("3")) {
            System.out.println("""
                    
                    ===== Ninja Menu =====
                    1. Create Ninja
                    2. List Ninjas
                    3. Close
                    
                    """);
            System.out.print("Choose an option: ");
            option = sc.nextLine().trim();
            System.out.println();

            switch (option) {
                case "1":
                    NinjaService.createNinja(sc, ninjaList);
                    break;

                case "2":
                    NinjaService.listNinjas(ninjaList);
                    break;

                case "3":
                    System.out.println("Closing program...");
                    option = "3";
                    break;

                default:
                    System.out.println("Invalid option");
                    option = "0";
            }
        }
    }
}

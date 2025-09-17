package challenge3.utils;

import challenge3.entities.Mission;
import challenge3.entities.Ninja;
import challenge3.services.NinjaService;

import java.util.List;
import java.util.Scanner;

public final class NinjaUtils {

    private NinjaUtils() {
    }

    public static void createMenu(Scanner sc, List<Ninja> ninjasList, List<Mission> missionsList) {
        String option = "0";
        while (!option.equals("13")) {
            System.out.print("""
                    
                    ========= Ninja Menu =========
                    1. Create ninja
                    2. List ninjas
                    3. Ninja details
                    4. Update ninja
                    5. Remove ninja
                    6. Assign a mission to a Ninja
                    7. Unassing a mission
                    8. Create mission
                    9. List missions
                    10. Mission details
                    11. Update mission
                    12. Remove mission
                    13. Close
                    ==============================
                    
                    """);
            option = NinjaService.readNonEmptyLine(sc, "Choose an option: ");
            System.out.println();

            switch (option) {
                case "1":
                    NinjaService.createNinja(ninjasList, sc);
                    break;

                case "2":
                    NinjaService.printList(ninjasList, "Ninjas");
                    break;

                case "3":
                    NinjaService.showItemDetails(ninjasList, sc, "Ninjas");
                    break;

                case "4":
                    NinjaService.updateNinja(ninjasList, sc);
                    break;

                case "5":
                    NinjaService.removeNinja(ninjasList, sc);
                    break;

                case "6":
                    NinjaService.assignMissionToNinja(ninjasList, missionsList, sc);
                    break;

                case "7":
                    NinjaService.unassignMissionFromNinja(ninjasList, sc);
                    break;

                case "8":
                    NinjaService.createMission(missionsList, sc);
                    break;

                case "9":
                    NinjaService.printList(missionsList, "Missions");
                    break;

                case "10":
                    NinjaService.showItemDetails(missionsList, sc, "Mission");
                    break;

                case "11":
                    NinjaService.updateMission(missionsList, sc);
                    break;

                case "12":
                    NinjaService.removeMission(missionsList, sc);
                    break;

                case "13":
                    System.out.println("Closing program...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
                    option = "0";
            }
        }
    }
}

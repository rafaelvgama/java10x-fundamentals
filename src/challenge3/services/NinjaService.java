package challenge3.services;

import challenge3.entities.Mission;
import challenge3.entities.Ninja;
import challenge3.entities.Uchiha;
import challenge3.enums.MissionRank;
import challenge3.enums.MissionStatus;
import challenge3.interfaces.HasName;

import java.util.List;
import java.util.Scanner;

public final class NinjaService {

    private NinjaService() {
    }

    public static void createNinja(List<Ninja> ninjasList, Scanner sc) {
        System.out.println("Creating ninja:");

        String ninjaName = readNonEmptyLine(sc, "Enter the ninja's name: ");

        Ninja checkNinjaExists = findItemByName(ninjasList, ninjaName);

        if (checkNinjaExists == null) {
            int ninjaAge = readValidInt(sc, "Enter the ninja's age: ");
            boolean hasAbility = askYesNo(sc, "Does ninja have special ability?");

            if (hasAbility) {
                String abilityName = readNonEmptyLine(sc, "Special Ability Name: ");
                ninjasList.add(new Uchiha(ninjaName, ninjaAge, abilityName));
            } else {
                ninjasList.add(new Ninja(ninjaName, ninjaAge));
            }
        } else {
            System.out.printf("Ninja with name '%s' already exists.%n", ninjaName);
        }
    }

    public static <T> void printList(List<T> list, String header) {
        if (list == null || list.isEmpty()) {
            System.out.printf("No %s to display.%n", header);
        } else {
            System.out.printf("Listing %s:%n", header);
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    public static <T extends HasName> void showItemDetails(List<T> list, Scanner sc, String header) {
        System.out.printf("%s details:%n", header);
        String itemName = readNonEmptyLine(sc, "Enter the " + header + "'s name: ");
        T itemFound = findItemByName(list, itemName);

        if (itemFound != null) {
            System.out.println(itemFound);
        } else {
            System.out.printf(
                    "No %s found with the name '%s'. Please, try again with a different name.%n",
                    header, itemName
            );
        }
    }

    public static void updateNinja(List<Ninja> ninjasList, Scanner sc) {
        System.out.println("Updating ninja: ");
        String ninjaName = readNonEmptyLine(sc, "Search for the ninja's name: ");
        Ninja ninjaToUpdate = findItemByName(ninjasList, ninjaName);

        if (ninjaToUpdate != null) {
            System.out.println("Ninja found.");
            System.out.println("Leave blank if you do not want to update.");
            updateObjectName(sc, ninjaToUpdate);
            updateNinjaAge(sc, ninjaToUpdate);
            if (ninjaToUpdate instanceof Uchiha uchiha) {
                updateUchihaSpecialAbility(sc, uchiha);
            }
            System.out.println("Ninja updated.");
        } else {
            System.out.printf("Ninja with name '%s' not found.%n", ninjaName);
        }
    }

    public static void removeNinja(List<Ninja> ninjasList, Scanner sc) {
        String name = readNonEmptyLine(sc, "Enter the ninja's name to remove: ");
        Ninja ninja = findItemByName(ninjasList, name);

        if (ninja == null) {
            System.out.printf("Ninja with name '%s' not found.%n", name);
            return;
        }

        if (ninja.getMission() != null) {
            System.out.println("Cannot remove ninja. Please unassign the mission first.");
            return;
        }

        ninjasList.remove(ninja);
        System.out.printf("Ninja '%s' removed.%n", name);
    }

    public static void createMission(List<Mission> missionsList, Scanner sc) {
        System.out.println("Creating mission:");

        String missionName = readNonEmptyLine(sc, "Enter the mission's name: ");

        Mission checkMissionExists = findItemByName(missionsList, missionName);

        if (checkMissionExists == null) {
            MissionRank missionRank = readMissionRank(sc);
            missionsList.add(new Mission(missionName, missionRank));
        } else {
            System.out.printf("Mission with name '%s' already exists.%n", missionName);
        }
    }

    public static void updateMission(List<Mission> missionsList, Scanner sc) {
        System.out.println("Updating mission:");
        String missionName = readNonEmptyLine(sc, "Search for the missions's name: ");
        Mission missionToUpdate = findItemByName(missionsList, missionName);

        if (missionToUpdate != null) {
            System.out.println("Mission found.");
            System.out.println("Leave blank if you do not want to update.");
            updateObjectName(sc, missionToUpdate);
            updateMissionRank(sc, missionToUpdate);
            updateMissionStatus(sc, missionToUpdate);
            System.out.println("Mission updated.");
        } else {
            System.out.printf("Mission with name '%s' not found.%n", missionName);
        }
    }

    public static void assignMissionToNinja(List<Ninja> ninjasList, List<Mission> missionsList, Scanner sc) {
        String ninjaName = readNonEmptyLine(sc, "Enter the ninja's name: ");
        Ninja ninjaFound = findItemByName(ninjasList, ninjaName);
        if (ninjaFound == null) {
            System.out.println("Ninja not found.");
            return;
        }

        String missionName = readNonEmptyLine(sc, "Enter the mission's name: ");
        Mission missionFound = findItemByName(missionsList, missionName);
        if (missionFound == null) {
            System.out.println("Mission not found.");
            return;
        }

        if (ninjaFound.getMission() == null) {
            if (missionFound.getNinja() == null) {
                ninjaFound.setMission(missionFound);
                missionFound.setNinja(ninjaFound);
                System.out.printf("Mission '%s' has been assigned to ninja '%s'.%n",
                        missionFound.getName(), ninjaFound.getName());
            } else {
                System.out.println("The selected mission is already assigned to a ninja.");
            }
        } else {
            System.out.println("The selected ninja already has a mission.");
        }
    }

    public static void unassignMissionFromNinja(List<Ninja> ninjasList, Scanner sc) {
        String ninjaName = readNonEmptyLine(sc, "Enter the ninja's name: ");
        Ninja ninjaFound = findItemByName(ninjasList, ninjaName);

        if (ninjaFound == null) {
            System.out.println("Ninja not found.");
            return;
        }

        if (ninjaFound.getMission() == null) {
            System.out.println("This ninja is not assigned to any mission.");
            return;
        }

        Mission mission = ninjaFound.getMission();
        ninjaFound.removeMission();
        System.out.printf("Ninja '%s' has been unassigned from mission '%s'.%n",
                ninjaName, mission.getName());
    }

    public static void removeMission(List<Mission> missionsList, Scanner sc) {
        String name = readNonEmptyLine(sc, "Enter the mission's name to remove: ");
        Mission mission = findItemByName(missionsList, name);

        System.out.println("mission: " + mission);

        if (mission == null) {
            System.out.printf("Mission with name '%s' not found.%n", name);
            return;
        }

        if (mission.getNinja() != null) {
            System.out.println("Cannot remove mission. Please unassign the ninja first.");
            return;
        }

        missionsList.remove(mission);
        System.out.printf("Mission '%s' removed.%n", name);
    }

    public static String readNonEmptyLine(Scanner sc, String prompt) {
        String input = "";
        while (input.isEmpty()) {
            System.out.print(prompt);
            input = sc.nextLine().trim();
        }
        return input;
    }

    public static int readValidInt(Scanner sc, String prompt) {
        while (true) {
            String input = readNonEmptyLine(sc, prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid integer.");
            }
        }
    }

    public static boolean askYesNo(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("y")) return true;
            if (input.equals("n")) return false;
            System.out.println("Invalid input. Please enter 'y' or 'n'.");
        }
    }

    private static <T extends HasName> T findItemByName(List<T> list, String name) {
        T itemFound = null;
        for (T item : list) {
            if (item.getName().equalsIgnoreCase(name)) {
                itemFound = item;
                break;
            }
        }
        return itemFound;
    }

    private static <T extends HasName> void updateObjectName(Scanner sc, T object) {
        System.out.print("New name: ");
        String newName = sc.nextLine().trim();
        if (!newName.isBlank()) {
            object.setName(newName);
        }
    }

    private static void updateNinjaAge(Scanner sc, Ninja ninja) {
        System.out.print("New age: ");
        String newAge = sc.nextLine().trim();
        if (!newAge.isBlank()) {
            try {
                int age = Integer.parseInt(newAge);
                ninja.setAge(age);
            } catch (NumberFormatException e) {
                System.out.println("Invalid age. Age not updated.");
            }
        }
    }

    private static void updateUchihaSpecialAbility(Scanner sc, Uchiha uchiha) {
        System.out.print("New special ability: ");
        String newSpecialAbility = sc.nextLine().trim();
        if (!newSpecialAbility.isBlank()) {
            uchiha.setSpecialAbility(newSpecialAbility);
        }
    }

    private static MissionRank readMissionRank(Scanner sc) {
        String input = readNonEmptyLine(sc, "Enter the mission's rank (S, A, B, C, D, E): ");
        return validRank(input, sc);
    }

    private static void updateMissionRank(Scanner sc, Mission mission) {
        System.out.print("New Rank (S, A, B, C, D, E): ");
        String input = sc.nextLine().toUpperCase().trim();
        if (!input.isBlank()) {
            mission.setRank(validRank(input, sc));
            System.out.println("Mission rank updated.");
        }
    }

    private static void updateMissionStatus(Scanner sc, Mission mission) {
        System.out.print("New status (NEW, PENDING, STARTED, COMPLETED, CANCELED): ");
        String input = sc.nextLine().toUpperCase().trim();
        if (!input.isBlank()) {
            mission.setStatus(validStatus(input, sc));
            System.out.println("Mission status updated.");
        }
    }

    private static MissionRank validRank(String input, Scanner sc) {
        MissionRank missionRank = null;
        boolean isValid = false;
        while (!isValid) {
            input = input.trim().toUpperCase();
            try {
                missionRank = MissionRank.valueOf(input);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid rank.");
                input = readNonEmptyLine(sc, "Enter the mission's rank (S, A, B, C, D, E): ");
            }
        }
        return missionRank;
    }

    private static MissionStatus validStatus(String input, Scanner sc) {
        MissionStatus missionStaus = null;
        boolean isValid = false;
        while (!isValid) {
            input = input.trim().toUpperCase();
            try {
                missionStaus = MissionStatus.valueOf(input);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid status.");
                input = readNonEmptyLine(sc,
                        "Enter the mission's status (NEW, PENDING, STARTED, COMPLETED, CANCELED): ");
            }
        }
        return missionStaus;
    }
}

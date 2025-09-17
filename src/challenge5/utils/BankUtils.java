package challenge5.utils;

import challenge5.entities.KonohaBank;
import challenge5.entities.BankAccount;
import challenge5.services.BankService;

import java.util.List;
import java.util.Scanner;

public final class BankUtils {

    private BankUtils() {
    }

    public static void createMenu(KonohaBank bank, List<BankAccount> acccountsList, Scanner sc) {
        String option = "0";
        while (!option.equals("8")) {
            System.out.println();
            System.out.println("""
                    ========= Ninja Menu =========
                    1. List accounts
                    2. Create accounts
                    3. Remove account
                    4. Deposit
                    5. Withdraw
                    6. Transfer value
                    7. Check balance
                    8. Close
                    ==============================
                    """);
            option = BankService.readNonEmptyString(sc, "Choose an option: ");
            System.out.println();

            switch (option) {
                case "1":
                    BankService.listAccounts(acccountsList);
                    break;

                case "2":
                    BankService.createAccounts(sc, bank, acccountsList);
                    break;

                case "3":
                    BankService.removeAccount(sc, acccountsList);
                    break;

                case "4":
                    BankService.deposit(sc, acccountsList);
                    break;

                case "5":
                    BankService.withdraw(sc, acccountsList);
                    break;

                case "6":
                    BankService.transfer(sc, acccountsList, bank);
                    break;

                case "7":
                    BankService.checkBalance(sc, acccountsList);
                    break;

                case "8":
                    System.out.println("Closing program...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    option = "0";
            }
        }
    }
}

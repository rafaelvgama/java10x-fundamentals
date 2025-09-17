package challenge5.services;

import challenge5.entities.KonohaBank;
import challenge5.entities.BankAccount;
import challenge5.entities.CheckingAccount;
import challenge5.entities.SavingsAccount;

import java.util.List;
import java.util.Scanner;

public final class BankService {

    private BankService() {
    }

    public static void listAccounts(List<BankAccount> accountsList) {
        if (accountsList.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("Listing accounts:");
            for (BankAccount account : accountsList) {
                System.out.println(account);
            }
        }
    }

    public static void createAccounts(Scanner sc, KonohaBank banco, List<BankAccount> accountsList) {
        System.out.println("Creating account:");
        String accountNumber = readNonEmptyString(sc, "Enter account number: ");

        BankAccount account = findAccountByNumber(accountsList, accountNumber);
        if (account != null) {
            System.out.println("This number is associated with another account.");
            return;
        }

        String clientName = readNonEmptyString(sc, "Enter client name: ");

        String accountType;
        while (true) {
            accountType = readNonEmptyString(sc, "Checking or Savings account? (c/s): ").toLowerCase();
            if (!accountType.equals("c") && !accountType.equals("s")) {
                System.out.println("Invalid account type.");
            } else {
                break;
            }
        }

        double initialDepositValue = readValidDouble(sc, "Enter initial deposit value (or 0 to skip): ");

        if (accountType.equals("c")) {
            if (initialDepositValue > 0) {
                banco.addAccount(new CheckingAccount(accountNumber, clientName, initialDepositValue));
            } else {
                banco.addAccount(new CheckingAccount(accountNumber, clientName));
            }
        } else {
            if (initialDepositValue > 0) {
                banco.addAccount(new SavingsAccount(accountNumber, clientName, initialDepositValue));
            } else {
                banco.addAccount(new SavingsAccount(accountNumber, clientName));
            }
        }
    }

    public static void removeAccount(Scanner sc, List<BankAccount> accountsList) {
        System.out.println("Removing account:");

        BankAccount account = findAccountByNumber(sc, accountsList);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        if (account.getBalance() != 0) {
            System.out.println("The account balance is not zero. The account cannot be removed.");
            return;
        }

        accountsList.remove(account);
    }

    public static void deposit(Scanner sc, List<BankAccount> accountsList) {
        System.out.println("Deposit:");

        BankAccount account = findAccountByNumber(sc, accountsList);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double depositValue = readValidDouble(sc, "Enter the deposit value: ");

        if (account.deposit(depositValue)) {
            System.out.printf("Amount deposited: R$ %.2f.\n", depositValue);
        } else {
            System.out.println("Invalid value.");
        }
    }

    public static void withdraw(Scanner sc, List<BankAccount> accountsList) {
        System.out.println("Withdraw:");

        BankAccount account = findAccountByNumber(sc, accountsList);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        double withdrawValue = readValidDouble(sc, "Enter the withdraw value: ");

        if (account.withdraw(withdrawValue)) {
            System.out.printf("Amount withdrawn from the account: R$ %.2f.\n", withdrawValue);
        } else {
            System.out.println("Invalid value.");
        }
    }

    public static void transfer(Scanner sc, List<BankAccount> accountsList, KonohaBank bank) {
        System.out.println("Transferring value:");

        String originAccountNumber = readNonEmptyString(sc, "Enter the origin account number: ");
        BankAccount originAccount = findAccountByNumber(accountsList, originAccountNumber);
        if (originAccount == null) {
            System.out.println("Origin account not found");
            return;
        }

        String destinationAccountNumber = readNonEmptyString(sc, "Enter the destination account number: ");
        BankAccount destinationAccount = findAccountByNumber(accountsList, destinationAccountNumber);
        if (destinationAccount == null) {
            System.out.println("Destination account not found");
            return;
        }

        double transferValue = readValidDouble(sc, "Enter the transfer value: ");
        if (transferValue > 0) {
            bank.transfer(originAccount, destinationAccount, transferValue);
            System.out.printf("Successful transfer value: R$ %.2f.\n", transferValue);
        } else {
            System.out.println("Invalid transfer value.");
        }
    }

    public static void checkBalance(Scanner sc, List<BankAccount> accountsList) {
        System.out.println("Check balance:");
        BankAccount account = findAccountByNumber(sc, accountsList);

        if (account != null) {
            System.out.printf("The account balance is R$ %.2f.%n", account.getBalance());
        } else {
            System.out.println("Account not found.");
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

    public static double readValidDouble(Scanner sc, String prompt) {
        while (true) {
            String input = readNonEmptyString(sc, prompt);
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid value");
            }
        }
    }

    private static BankAccount findAccountByNumber(Scanner sc, List<BankAccount> list) {
        String input = readNonEmptyString(sc, "Enter account number: ");
        for (BankAccount account : list) {
            if (account.getAccountNumber().equals(input)) {
                return account;
            }
        }
        return null;
    }

    private static BankAccount findAccountByNumber(List<BankAccount> list, String accountNumber) {
        for (BankAccount account : list) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}

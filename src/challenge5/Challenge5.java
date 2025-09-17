package challenge5;

import challenge5.entities.KonohaBank;
import challenge5.entities.BankAccount;
import challenge5.utils.BankUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Challenge5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Locale.setDefault(Locale.US);

        List<BankAccount> accountsList = new ArrayList<>();

        KonohaBank bank = new KonohaBank(accountsList);

        BankUtils.createMenu(bank, accountsList, sc);

        sc.close();

    }
}

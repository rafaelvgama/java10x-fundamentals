package challenge5.entities;

import java.util.List;

public class KonohaBank {
    private List<BankAccount> accountsList;

    public KonohaBank(List<BankAccount> accountsList) {
        this.accountsList = accountsList;
    }

    public List<BankAccount> getAccounts() {
        return this.accountsList;
    }

    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : this.accountsList) {
            if (accountsList.contains(account) && account.accountNumber.equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void addAccount(BankAccount account) {
        this.accountsList.add(account);
    }

    public void removeAccount(BankAccount account) {
        this.accountsList.remove(account);
    }

    public void transfer(BankAccount origin, BankAccount destination, double value) {
        if (origin.withdraw(value)) {
            destination.deposit(value);
        } else {
            System.out.println("Insufficient balance");
        }
    }

}

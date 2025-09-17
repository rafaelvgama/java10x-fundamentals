package challenge5.entities;

import challenge5.enums.AccountType;

public class SavingsAccount extends BankAccount {
    private final AccountType accountType = AccountType.SAVINGS_ACCOUNT;

    public SavingsAccount(String accountNumber, String clientName) {
        super(accountNumber, clientName);
    }

    public SavingsAccount(String accountNumber, String clientName, double deposit) {
        super(accountNumber, clientName, deposit);
        deposit(deposit);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public boolean deposit(double value) {
        if (value > 0) {
            setBalance(this.balance += value);
            return true;
        } else {
            System.out.println("Invalid deposit value.");
        }
        return false;
    }

    @Override
    public boolean withdraw(double valor) {
        if (this.balance >= valor) {
            setBalance(this.balance -= valor);
            return true;
        } else {
            System.out.println("Insufficient balance.");
        }
        return false;
    }

    @Override
    public String toString (){
        return String.format("""
                Account number: %s,
                Client name: %s,
                Account type: %s,
                """,
                accountNumber, clientName, getAccountType());
    }
}

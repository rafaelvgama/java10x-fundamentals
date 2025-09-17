package challenge5.entities;

import challenge5.enums.AccountType;

public class CheckingAccount extends BankAccount {
    private final AccountType accountType = AccountType.CHECKING_ACCOUNT;

    public CheckingAccount(String accountNumber, String clientName) {
        super(accountNumber, clientName);
    }

    public CheckingAccount(String accountNumber, String clientName, double deposit) {
        super(accountNumber, clientName, deposit);
        deposit(deposit);
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public boolean deposit(double valor) {
        if (valor > 0) {
            setBalance(this.balance += valor);
            return true;
        } else {
           return false;
        }
    }

    @Override
    public boolean withdraw(double value) {
        double withdrawTax = 1.0;
        if (this.balance >= value + withdrawTax) {
            setBalance(this.balance -= (value + withdrawTax));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString (){
        return String.format("""
                Account number: %s,
                Client name: %s,
                Account type: %s,
                """,
                accountNumber,
                clientName,
                getAccountType().name().replace("_", " ").toLowerCase());
    }
}


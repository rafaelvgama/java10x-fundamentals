package challenge5.entities;

import challenge5.enums.AccountType;
import challenge5.interfaces.Account;

public abstract class BankAccount implements Account {
    protected String accountNumber;
    protected String clientName;
    protected double balance;

    public BankAccount(String accountNumber, String clientName) {
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.balance = 0;
    }

    public BankAccount(String accountNumber, String clientName, double deposit) {
        this.accountNumber = accountNumber;
        this.clientName = clientName;
        this.balance = 0;
    }

    public abstract AccountType getAccountType();

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void viewBalance() {
        System.out.printf("Current balance: R$ %.2f%n", this.balance);
    }

    @Override
    public abstract boolean deposit(double valor);

    @Override
    public abstract boolean withdraw(double valor);
}

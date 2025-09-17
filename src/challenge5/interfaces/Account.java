package challenge5.interfaces;

public interface Account {
    void viewBalance();

    boolean deposit(double valor);

    boolean withdraw(double valor);
}

package Lab11.Task3;

public class Account {
    private int balance;

    public synchronized void income(int amount) {
        balance += amount;
    }

    public synchronized void outcome(int amount) {
        balance -= amount;
    }

    public synchronized int getBalance() {
        return balance;
    }
}

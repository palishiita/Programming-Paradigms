package Lab11.Task2;

public class Account {
    private int balance;

    public void income(int amount) {
        balance += amount;
    }

    public void outcome(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}







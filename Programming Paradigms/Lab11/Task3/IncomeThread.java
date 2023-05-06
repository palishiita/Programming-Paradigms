package Lab11.Task3;

public class IncomeThread extends Thread {
    private final Account account;

    public IncomeThread(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            account.income(1);
        }
    }
}

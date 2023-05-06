package Lab11.Task2;

public class OutcomeThread extends Thread {
    private final Account account;

    public OutcomeThread(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            account.outcome(1);
        }
    }
}

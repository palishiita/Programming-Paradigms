package Lab11.Task2;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        IncomeThread incomeThread = new IncomeThread(account);
        OutcomeThread outcomeThread = new OutcomeThread(account);
        incomeThread.start();
        outcomeThread.start();
    }
}

package Lab11.Task3;

public class ClassTask3 {

    private int accountBalance = 0;

    public synchronized void incrementBalance() {
        accountBalance++;
    }

    public synchronized void decrementBalance() {
        accountBalance--;
    }

    public void getAccountBalance() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++) {
                    incrementBalance();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 100; i++) {
                    decrementBalance();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Account Balance: " + accountBalance);

    }

    public static void main(String[] args) {
        ClassTask3 task = new ClassTask3();
        task.getAccountBalance();
    }
}

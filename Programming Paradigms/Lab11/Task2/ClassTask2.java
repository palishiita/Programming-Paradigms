package Lab11.Task2;

public class ClassTask2 {

    private int accountBalance = 0;

    public void incrementBalance() {
        accountBalance++;
    }

    public void decrementBalance() {
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
        ClassTask2 task = new ClassTask2();
        task.getAccountBalance();
    }
}

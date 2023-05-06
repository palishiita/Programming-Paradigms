package Lab11;

/**
Q1. What will be printed by first code presented in this instruction and why?
 printed:
    Hello main
    Done!
    Hello Thread-0
 why:
    First we execute the runnable directly on the main thread before starting a new thread.
    Due to concurrent execution we cannot predict if the runnable will be invoked before or after printing "Done!".
    The order is non-deterministic, thus making concurrent programming a complex task in larger applications.
**/

public class Task1 extends Thread {
    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };
        task.run();
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("Done!");
    }
}



package Lab11;

/*
Q5. Use one of ExecutorServices and print next int number (starting from 0) each second (can be limited to 30 times).
    Which type of ExecutorService is the best for this task and why?
 - In the below program, we used a ScheduledExecutorService
 - ScheduledExecutorService is a sub-interface of ExecutorService that provides scheduling capabilities to execute
   tasks at a future time.
 - It is a good as it provides a flexible and efficient means of creating and executing tasks.
 - It allows you to schedule tasks to run one-time or on a recurring basis, with a variety of options for customizing
   the schedule.
*/

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Task5 {
    public static void main(String[] args) {
        // create a ScheduledExecutorService with a single thread
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        // create a Runnable task that will print the next integer every second
        Runnable task = new Runnable() {
            int i = 0;
            @Override
            public void run() {
                System.out.println(i++);
            }
        };
        // schedule the task to run every second for 30 iterations
        executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}
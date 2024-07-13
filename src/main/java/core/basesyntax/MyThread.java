package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // Generate a random task duration between 100 and 500 milliseconds
        int taskDuration = ThreadLocalRandom.current().nextInt(100, 501);

        // Suspend the thread for the generated duration
        Thread.sleep(taskDuration);

        // Get the current time when the task finishes
        LocalTime finishTime = LocalTime.now();

        // Return the result string
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, finishTime);
    }
}
package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        // Generate a random duration between 100 and 500 milliseconds
        int duration = 100 + random.nextInt(401);
        Thread.sleep(duration); // Simulate work by sleeping

        // Get the finish time
        LocalTime finishTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String formattedTime = finishTime.format(formatter);

        // Return the result string
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, formattedTime);
    }
}

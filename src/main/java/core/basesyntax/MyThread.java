package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Integer LOWER_BOUND = 100;
    private static final Integer UPPER_BOUND = 700;

    @Override
    public String call() throws InterruptedException {
        // write your code here
        int duration = new Random().nextInt(UPPER_BOUND - LOWER_BOUND) + LOWER_BOUND;
        Thread.sleep(duration);
        return generateMessage(duration, LocalTime.now());
    }

    private String generateMessage(long duration, LocalTime currentTime) {
        return new StringBuilder()
                     .append("Task duration was ")
                     .append(duration)
                     .append(" ms, ")
                     .append("execution finished at ")
                     .append(currentTime).toString();
    }
}

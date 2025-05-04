package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        Random random = new Random();
        int duration = 100 + random.nextInt(500);
        Thread.sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
            duration, LocalTime.now());
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random rand = new Random();
        int wait_time_ms = (rand.nextInt(5) + 1) * 100;
        Thread.sleep(wait_time_ms);
        return String.format("Task duration was %d ms, execution finished at %s", wait_time_ms, LocalTime.now());
    }
}

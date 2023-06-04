package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int randomTimePause = random.nextInt(100);
        long start = System.currentTimeMillis();
        Thread.sleep(randomTimePause);
        LocalTime localTime = LocalTime.now();
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        return "Task duration was " + timeElapsed + " ms, execution finished at " + localTime;
    }
}

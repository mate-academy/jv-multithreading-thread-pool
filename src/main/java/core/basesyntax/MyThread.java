package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Random random = new Random();
        int timePause = random.nextInt(100);
        Thread.sleep(timePause);
        LocalTime localTime = LocalTime.now();
        long finish = System.currentTimeMillis();
        long time = start - finish;
        return "Task duration was " + time + " ms, execution finished at " + localTime;
    }
}

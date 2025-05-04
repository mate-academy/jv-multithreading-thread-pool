package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int sleepMillis = new Random().nextInt(1000);
        Thread.sleep(sleepMillis);
        LocalTime time = LocalTime.now();
        System.out.println();
        return String.format("Task duration was %s ms, execution finished at %s",sleepMillis, time);
    }
}

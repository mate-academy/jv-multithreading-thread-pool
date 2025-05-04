package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long duration = rnd(1, 5);

        Thread.sleep(duration);
        return "Task duration was " + duration + " ms, execution finished at " + LocalTime.now();
    }

    public static long rnd(int min, int max) {
        max -= min;
        return (long) ((Math.random() * ++max) + min) * 100;
    }
}

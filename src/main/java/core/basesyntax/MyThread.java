package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random rand = new Random();

    @Override
    public String call() throws InterruptedException {
        int zzz = rand.nextInt(500);
        Thread.sleep(zzz);
        return String.format("Task duration was %d ms, execution finished at %s", zzz,
            LocalTime.now());
    }
}

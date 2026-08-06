package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomValue = new Random()
                .ints(1, 6)
                .findFirst()
                .getAsInt() * 100;
        Thread.sleep(randomValue);
        return "Task duration was " + randomValue + " ms, execution finished at " + LocalTime.now();
    }
}

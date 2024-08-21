package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        int random = new Random().nextInt(500);
        Thread.sleep(random);
        return String.format("Task duration was %d ms, execution finished at %s",
                random, LocalTime.now());
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomMilliseconds = new Random().nextInt(100);
        Thread.sleep(randomMilliseconds);
        return String.format("Task duration was %s ms, execution finished at %s",
                randomMilliseconds, LocalTime.now());
    }
}

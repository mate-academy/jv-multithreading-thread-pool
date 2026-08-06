package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        long threadWork = random.nextInt(500);
        Thread.sleep(threadWork);
        return String.format("Task duration was %s ms, execution finished at %s",
                threadWork, LocalTime.now());
    }
}

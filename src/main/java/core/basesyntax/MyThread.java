package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int timeSleep = new Random().nextInt(1000);
        LocalDateTime localDateTime = LocalDateTime.now();
        Thread.sleep(timeSleep);
        return String.format("Task duration was %d ms, execution finished at %s",
                timeSleep,
                localDateTime.plusNanos(timeSleep).toString());
    }
}

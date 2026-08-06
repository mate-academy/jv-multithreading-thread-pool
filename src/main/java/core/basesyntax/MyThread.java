package core.basesyntax;

import static java.lang.Thread.sleep;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int duration = random.nextInt(401) + 100;
        sleep(duration);
        return String.format("Task duration was %d ms, execution finished at %s",
                duration, LocalDateTime.now());
    }
}

package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String PATTERN_MESSAGE
            = "Task duration was %s ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        int sleep = new Random().nextInt(500);
        Thread.sleep(sleep);
        return String.format(PATTERN_MESSAGE, sleep, LocalDateTime.now());
    }
}

package core.basesyntax;

import static java.lang.Thread.sleep;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {

    public static final int BOUND = 1000;

    @Override
    public String call() throws InterruptedException {
        LocalTime start = LocalTime.now();

        sleep(ThreadLocalRandom.current().nextInt(BOUND));

        LocalTime finish = LocalTime.now();

        return String.format("Task duration was %d ms, execution finished at %s",
                Duration.between(start, finish).toMillis(),
                finish);
    }
}

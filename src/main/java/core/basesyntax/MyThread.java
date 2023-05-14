package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        long randomDuration = (random.nextInt(10) + 1) * 100;
        Thread.sleep(randomDuration);
        return String.format("Task duration was %d ms, execution finished at %s",
                randomDuration,
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS")));
    }
}

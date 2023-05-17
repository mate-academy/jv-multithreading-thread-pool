package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        long threadDuration = (random.nextInt(5) + 1) * 100;
        Thread.sleep(threadDuration);
        return "Task duration was %s, execution finished at %s"
                .formatted(threadDuration,
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH.mm.ss.SSSSSS")));
    }
}

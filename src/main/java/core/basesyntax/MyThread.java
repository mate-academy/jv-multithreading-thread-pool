package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("HH:mm:ss.SSSSSS");

    @Override
    public String call() throws InterruptedException {
        int duration = ThreadLocalRandom.current().nextInt(1, 6) * 100;
        Thread.sleep(duration);
        String time = LocalTime.now().format(FORMATTER);
        return String.format("Task duration was %d ms, execution finished at %s", duration, time);
    }
}

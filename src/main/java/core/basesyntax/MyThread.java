package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("HH:mm:ss.SSSSSS");

    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int duration = (random.nextInt(5) + 1) * 100;
        Thread.sleep(duration);

        String formattedTime = LocalDateTime.now().format(FORMATTER);

        return String.format("Task duration was %d ms, execution finished at %s",
                duration,
                formattedTime);
    }
}

package core.basesyntax;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String TIME_FORMAT = "HH:mm:ss.SSSSSS";

    @Override
    public String call() throws InterruptedException {
        int taskDuration = (new Random().nextInt(5) + 1) * 100;
        Thread.sleep(taskDuration);
        LocalDateTime localDateTime = LocalDateTime.now();
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, localDateTime.format(DateTimeFormatter.ofPattern(TIME_FORMAT)));
    }
}

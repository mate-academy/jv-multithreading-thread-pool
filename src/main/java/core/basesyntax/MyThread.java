package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final DateTimeFormatter TIME_FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");
    @Override
    public String call() throws InterruptedException {
        long suspendPeriod = 100 + new Random().nextInt(900);
        Thread.sleep(suspendPeriod);
        return String.format("Task duration was %d ms, execution finished at %s",
                suspendPeriod, LocalTime.now().format(TIME_FORMATTER));
    }
}

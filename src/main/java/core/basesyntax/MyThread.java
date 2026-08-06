package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String format = "Task duration was %d ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int duration = (random.nextInt(8) + 1) * 100;
        Thread.sleep(duration);
        return String.format(format, duration,
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS")));
    }
}

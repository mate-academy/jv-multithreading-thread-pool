package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int duration = 100 + random.nextInt(400);
        Thread.sleep(duration);
        String finishTime = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS"));
        return String.format("Task duration was %d ms, execution finished at %s", duration, finishTime);
    }
}

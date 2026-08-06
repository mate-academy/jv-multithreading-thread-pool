package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        long sleepTime = 100 + (long)(Math.random() * 400);
        Thread.sleep(sleepTime);

        long endTime = System.currentTimeMillis();
        long durationTime = endTime - startTime;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
        String formattedTime = LocalTime.now().format(formatter);

        return "Task duration was " + durationTime + " ms, execution finished at " + formattedTime;
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        //Task duration was 200 ms, execution finished at 11:27:47.243785
        long sleepTime = (1L + (long) (Math.random() * (9L - 1L))) * 100;
        Thread.sleep(sleepTime);
        String formatted = "Task duration was %d ms, execution finished at %s"
                .formatted(sleepTime, LocalTime.now());
        return formatted;
    }
}

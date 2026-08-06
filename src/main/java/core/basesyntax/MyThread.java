package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long startTime = System.nanoTime();

        Thread.sleep(200);

        long endTime = System.nanoTime();

        long durationInMillis = (endTime - startTime) / 1_000_000; // Перетворення на мілісекунди

        return String.format(
                "Task duration was %d ms, execution finished at %s",
                durationInMillis, LocalTime.now()
        );
    }
}

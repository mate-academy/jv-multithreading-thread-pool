package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime before = LocalTime.now();
        long nanoOfDayBefore = before.toNanoOfDay();
        int sleep = new Random().nextInt(500);
        Thread.sleep(sleep);

        long nanoOfDayAfter = LocalTime.now().toNanoOfDay();

        long difference = nanoOfDayAfter - nanoOfDayBefore;

        return String.format(
                "Task duration was %s ms, execution finished at %s",
                difference / 1_000_000,
                before
        );
    }
}

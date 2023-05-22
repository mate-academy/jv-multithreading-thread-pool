package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int milliSeconds = new Random().nextInt(500);
        Thread.sleep(milliSeconds);
        return String.format("Task duration was %s ms, execution finished at %s",
                milliSeconds, LocalTime.now().toString());
    }
}

package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int i = new Random().nextInt(10);
        i = 10 * (i + 1);
        Thread.sleep(i);
        return String.format(
                "Task duration was %d ms, execution finished at %s", i, LocalDateTime.now());
    }
}

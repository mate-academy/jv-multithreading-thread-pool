package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        return String.format("Task duration was %s ms, execution finished at %s",
                (new Random().nextInt(5) + 1) * 100, LocalTime.now());
    }
}

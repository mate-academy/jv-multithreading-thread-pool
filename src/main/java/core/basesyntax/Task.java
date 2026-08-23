package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        return "Task duration was " + new Random().nextInt(1000) + " ms, execution"
            + " finished at " + LocalTime.now();
    }
}

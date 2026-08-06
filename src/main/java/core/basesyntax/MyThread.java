package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        return String.format("Task duration was %s ms, execution finished at %s%n",
                random.nextInt(200),
                LocalTime.now());
    }
}

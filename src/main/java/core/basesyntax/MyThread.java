package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int[] options = {100, 200, 300, 400, 500};
        int sleep = options[ThreadLocalRandom.current().nextInt(options.length)];
        Thread.sleep(sleep);
        return String.format("Task duration was %d ms, "
                + "execution finished at %s", sleep, LocalTime.now());
    }
}

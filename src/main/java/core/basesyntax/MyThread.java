package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        int millis = ThreadLocalRandom.current().nextInt(1, 6) * 100;
        Thread.sleep(millis);
        return String.format("Task duration was %d ms, execution finished at %s", millis,
                LocalTime.now());
    }
}

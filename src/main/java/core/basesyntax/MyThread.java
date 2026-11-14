package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int timeDuration = ThreadLocalRandom.current().nextInt(1, 4) * 100;
        Thread.sleep(timeDuration);
        return "Task duration was " + timeDuration + " ms, execution finished at "
                + LocalTime.now();
    }
}

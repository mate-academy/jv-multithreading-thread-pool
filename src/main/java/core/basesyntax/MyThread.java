package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() {
        return "Task duration was"
                + ThreadLocalRandom.current().nextInt(100, 501)
                + " ms, execution finished at "
                + LocalDateTime.now();
    }
}

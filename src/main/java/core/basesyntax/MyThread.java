package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Callable<String> {
    private static final Logger log = LogManager.getLogger(MyThread.class);

    @Override
    public String call() {
        long duration = ThreadLocalRandom.current().nextLong(0L, 500L);
        LocalTime time = LocalTime.now();

        log.info("Task duration was {} ms, execution finished at {}", duration, time);

        return String.format("Task duration was %s ms, execution finished at %s%n", duration, time);
    }
}

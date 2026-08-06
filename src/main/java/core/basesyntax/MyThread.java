package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Callable<String> {
    private static final Logger logger = LogManager.getLogger(MyThread.class);
    private static Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        // write your code here
        long taskDuration = ThreadLocalRandom.current().nextLong(1000L);
        Thread.sleep(taskDuration);
        String log = String.format("Task duration was %s ms, execution finished at %s",
                taskDuration, LocalTime.now());
        logger.info(log);
        return log;
    }
}

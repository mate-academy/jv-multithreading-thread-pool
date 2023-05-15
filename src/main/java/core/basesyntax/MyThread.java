package core.basesyntax;

import static java.lang.Thread.sleep;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Callable<String> {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        LocalDateTime begin = LocalDateTime.now();
        sleep(random.nextInt(1000));
        LocalDateTime end = LocalDateTime.now();
        logger.info("Task duration was " + ChronoUnit.MILLIS.between(begin, end)
                + " ms, execution finished at " + end.toLocalTime());
        return "Task duration was " + ChronoUnit.MILLIS.between(begin, end)
                + " ms, execution finished at " + end;
    }
}

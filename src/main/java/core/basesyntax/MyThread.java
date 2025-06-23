package core.basesyntax;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

public class MyThread implements Callable<String> {
    private static final Logger logger = (Logger) LogManager.getLogger(MyThread.class);
    private static final Random RANDOM = new Random();
    private static final int MIN_DURATION = 100;
    private static final int MAX_DURATION = 500;
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSS");

    @Override
    public String call() throws InterruptedException {
        int duration = RANDOM.nextInt(MAX_DURATION - MIN_DURATION + 1) + MIN_DURATION;
        Thread.sleep(duration);
        LocalTime finishTime = LocalTime.now();
        String result = String.format("Task duration was %d ms, execution finished at %s",
                duration,finishTime.format(FORMATTER));
        logger.info(result);
        return result;
    }
}

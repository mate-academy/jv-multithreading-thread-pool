package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Callable<String> {
    private static final Random RANDOM = new Random();
    private static final Logger logger = LogManager.getLogger(MyThread.class);

    @Override
    public String call() throws InterruptedException {
        int duration = RANDOM.nextInt(400) + 100;
        Thread.sleep(duration);
        LocalTime endTime = LocalTime.now();
        String result = "Task duration was " + duration + " ms, execution finished at " + endTime;
        logger.info(result);
        return result;
    }
}

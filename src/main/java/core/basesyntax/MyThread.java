package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread implements Callable<String> {
    private static final Logger logger = LogManager.getLogger(MyThread.class);
    private final int duration;

    public MyThread(int duration) {
        this.duration = duration;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(duration);
        LocalTime endTime = LocalTime.now();
        String result = "Task duration was " + duration + " ms, execution finished at " + endTime;
        logger.info("Thread completed: " + result);
        return result;
    }
}

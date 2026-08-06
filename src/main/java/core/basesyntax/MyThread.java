package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int STOP_TIME = 200;
    private static final String RESULT_MESSAGE =
            "Task duration was %d ms, execution finished at %s";

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(STOP_TIME);
        return String.format(RESULT_MESSAGE, STOP_TIME, LocalTime.now());
    }
}

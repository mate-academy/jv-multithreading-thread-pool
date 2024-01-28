package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int WORKING_TIME = 200;
    private static final String RETURN_MESSAGE
            = "Task duration was %s ms, execution finished at %s%n";

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(WORKING_TIME);
        return String.format(RETURN_MESSAGE, WORKING_TIME, LocalTime.now());
    }
}

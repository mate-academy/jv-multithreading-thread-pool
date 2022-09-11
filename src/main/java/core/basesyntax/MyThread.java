package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int START_RANGE_MS = 10;
    private static final int END_RANGE_MS = 1000;

    @Override
    public String call() throws Exception {
        int time = (int) (START_RANGE_MS + Math.random() * END_RANGE_MS);
        Thread.sleep(time);
        return String.format("Task duration was %s ms, execution finished at %s", time, LocalTime.now());
    }
}

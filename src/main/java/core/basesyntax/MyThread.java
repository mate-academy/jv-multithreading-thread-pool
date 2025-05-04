package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    private static final String MESSAGE = "Task duration was %2d  ms, execution finished at %s";

    @Override
    public String call() throws Exception {
        int random100 = ThreadLocalRandom.current().nextInt(1, 9) * 100;
        Thread.sleep(random100);
        return String.format(MESSAGE, random100, LocalTime.now());
    }
}

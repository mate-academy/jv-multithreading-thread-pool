package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() {
        return "Task duration was "
                + (new Random().nextInt(6) + 1) * 100 + " ms , execution finished at "
                + LocalTime.now();
    }
}

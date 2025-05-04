package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final int RANGE = 200;

    @Override
    public String call() throws InterruptedException {
        int time = new Random().nextInt(RANGE);
        Thread.sleep(time);
        LocalTime currentTime = LocalTime.now();
        return String.format(
                "Task duration was %s ms, execution finished at %s%n",
                time,
                currentTime
        );
    }
}

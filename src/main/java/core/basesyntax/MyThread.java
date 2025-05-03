package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    public static final Random RANDOM = new Random();

    @Override
    public String call() throws InterruptedException {
        int duration = (RANDOM.nextInt(5) + 1) * 100;
        Thread.sleep(100);
        return String.format(
                "Task duration was %s ms, execution finished at %s",
                duration, LocalTime.now()
        );
    }
}

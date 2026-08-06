package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int duration = (random.nextInt(5) + 1) * 100; // 100,200,...500 ms
        Thread.sleep(duration);
        LocalTime finishTime = LocalTime.now();
        return String.format(
                "Task duration was %d ms, execution finished at %s",
                duration, finishTime.toString()
        );
    }
}

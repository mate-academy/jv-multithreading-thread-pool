package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final Random RANDOM = new Random();

    @Override
    public String call() throws InterruptedException {
        // write your code here
        int duration = (RANDOM.nextInt(5) + 1) * 100; // 100–500 ms
        Thread.sleep(duration);

        return "Task duration was " + duration
                + " ms, execution finished at " + LocalTime.now();
    }
}

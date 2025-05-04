package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int taskDuration = random.nextInt(600);
        Thread.sleep(taskDuration);
        return "Task duration was " + taskDuration + "ms, "
                + "executrion finished at " + LocalTime.now();
    }
}

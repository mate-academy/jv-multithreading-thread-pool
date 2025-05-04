package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int duration = random.nextInt(500);
        Thread.sleep(duration);
        String res = "Task duration was " + duration + " ms, execution finished at ";
        return res + LocalTime.now();
    }
}

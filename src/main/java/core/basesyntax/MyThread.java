package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random rand = new Random();
        int duration = rand.nextInt(400) + 100;
        Thread.sleep(duration);
        LocalTime finishTime = LocalTime.now();
        return String.format("Task duration was %d ms, execution finished at %s", duration, finishTime);
    }
}

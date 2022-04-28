package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int sleepTime = random.nextInt(200,300);
        Thread.sleep(sleepTime);
        return "Task duration was " + sleepTime + " ms, execution finished at " + LocalTime.now();
    }
}

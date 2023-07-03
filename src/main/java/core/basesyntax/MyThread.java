package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int randomInt = random.nextInt(5) * 100 + 100;
        Thread.sleep(200);
        return String.format("Task duration was %s ms, execution finished at %s",
                randomInt, LocalTime.now());
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();

        int millis = random.nextInt(1, 8) * 100;
        Thread.sleep(millis);

        return "Task duration was %s ms, execution finished at %s"
                .formatted(millis, LocalTime.now());
    }
}

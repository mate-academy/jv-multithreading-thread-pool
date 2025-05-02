package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = ThreadLocalRandom.current().nextInt(100, 501);
        Thread.sleep(duration);
        String finishTime = LocalTime.now().toString();
        return String.format(
                "Task duration was %d ms, execution finished at %s",
                duration, finishTime
        );
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class MyThread implements Callable<String> {
    @Override
    public String call() {
        String result = "";
        try {
            int sleepingTime = ThreadLocalRandom.current().nextInt(1000);
            result = "Task duration was "
                    + sleepingTime + ", execution finished at " + LocalTime.now();
            Thread.sleep(sleepingTime);
            return result;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return result;
    }
}

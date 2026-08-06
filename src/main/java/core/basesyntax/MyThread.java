package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomDuration = (new Random().nextInt(9) + 1) * 100;
        Thread.sleep(randomDuration);
        return String.format("Task duration was %d ms, execution finished at %tT.%tN",
                randomDuration,
                LocalTime.now(),
                LocalTime.now());
    }
}

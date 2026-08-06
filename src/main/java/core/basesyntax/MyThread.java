package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Long[] array = {100L, 200L, 300L, 400L, 500L};
        Random random = new Random();
        Long period = array[random.nextInt(array.length)];
        Thread.sleep(period);
        return String.format("Task duration was %1$d ms, "
                        + "execution finished at %2$tH:%2$tM:%2$tS.%2$tL",
                period,
                LocalTime.now());
    }
}

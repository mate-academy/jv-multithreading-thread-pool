package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Random random = new Random();
        int number = random.nextInt(150);

        Thread.sleep(number);
        return "Task duration was " + number + " ms, execution finished at" + LocalTime.now();
    }
}

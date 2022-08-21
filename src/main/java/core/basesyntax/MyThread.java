package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private int random;
    private Random ran = new Random();

    @Override
    public String call() throws InterruptedException {
        random = (ran.nextInt(8) + 1) * 100;
        Thread.sleep(random);
        return "Task duration was " + random
                + " ms, execution finished at " + LocalTime.now().toString();
    }
}

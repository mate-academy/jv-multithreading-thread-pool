package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private int[] array = new int[]{100, 200, 300, 400, 500};
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        int sleep = getRandom();
        Thread.sleep(sleep);
        return "Task duration was "
                + sleep
                + ", execution finished at "
                + LocalTime.now();
    }

    private int getRandom() {
        return array[random.nextInt(5)];
    }
}

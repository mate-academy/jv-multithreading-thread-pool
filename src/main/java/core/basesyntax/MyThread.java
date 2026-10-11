package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {

    @Override
    public String call() throws InterruptedException {
        int durationTask = new Random().nextInt(5) * 100 + 100;
        Thread.sleep(durationTask);
        LocalTime time = LocalTime.now();
        return "Task duration was " + durationTask + " ms, " + "execution finished at " + time;
    }
}

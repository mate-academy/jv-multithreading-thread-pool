package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static String MESSAGE = "Task duration was %d ms, execution finished at %s";
    @Override
    public String call() throws InterruptedException {
        int workTime = new Random().nextInt(1000);
        Thread.sleep(workTime);
        return String.format(MESSAGE, workTime, LocalTime.now());
    }
}

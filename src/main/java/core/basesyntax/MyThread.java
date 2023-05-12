package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomNum = new Random().nextInt(1) + 199;
        Thread.sleep(randomNum);
        return String.format("Task duration was %d ms, execution finished at %s", randomNum, LocalTime.now());
    }
}

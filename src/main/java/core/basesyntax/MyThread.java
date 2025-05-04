package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        Random random = new Random();
        Integer duration = random.nextInt(200);
        Thread.sleep(duration);
        return "Task duration was "
                + duration.toString()
                + " ms, execution finished at "
                + LocalTime.now().toString();
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int[] duration = new int[] {100, 200, 300, 400, 500};
        Random random = new Random();
        int index = random.nextInt(5);
        synchronized (this) {
            wait(duration[index]);
        }
        return "Task duration was " + duration[index] + " ms, execution finished at " +  LocalTime.now().toString();
    }
}

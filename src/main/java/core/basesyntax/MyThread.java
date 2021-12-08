package core.basesyntax;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static ThreadLocal<Integer> duration = new ThreadLocal<>();

    @Override
    public String call() throws InterruptedException {
        duration.set(new Random().nextInt(100));
        Thread.sleep(duration.get());
        return "Task duration was "
                + duration.get()
                + " ms, execution finished at "
                + LocalDateTime.now();
    }
}

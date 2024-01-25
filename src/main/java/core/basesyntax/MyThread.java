package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread.sleep(500);
        long finish = System.currentTimeMillis();
        long working = finish - start;
        return String.format(
                "Task duration was %s ms, execution finished at %s",
                working, LocalTime.now()
        );
    }
}

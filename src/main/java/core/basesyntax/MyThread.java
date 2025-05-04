package core.basesyntax;

import java.time.LocalTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        LocalTime time = LocalTime.now();
        Thread.sleep(10);
        return String.format("Task duration was %s ms, execution finished at %s, %s",
                String.valueOf(Math.abs(time.getNano()
                        - LocalTime.now().getNano())).substring(0, 4),
                LocalTime.now().toString().substring(0, 13),
                Thread.currentThread());
    }
}

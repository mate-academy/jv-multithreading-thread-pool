package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final LocalDateTime time = LocalDateTime.now();

    @Override
    public String call() throws InterruptedException {
        float duration = (float) (LocalDateTime.now().getNano() - time.getNano()) / 1000000;
        return "Task duration was " + duration + " ms, execution finished at "
                + LocalDateTime.now();
    }
}

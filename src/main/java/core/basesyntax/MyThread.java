package core.basesyntax;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        // write your code here
        int randomNum = (int)(Math.random() * 101);
        Thread.sleep(randomNum);
        return "Task duration was " + randomNum + " ms, execution finished at "
                + LocalDateTime.now();
    }
}

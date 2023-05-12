package core.basesyntax;

import static java.lang.Thread.sleep;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private SecureRandom random = new SecureRandom();

    @Override
    public String call() throws InterruptedException {
        int randomInt = random.nextInt(1000);
        sleep(randomInt);
        return String.format(
                "Task duration was %d ms, execution finished at %s",
                randomInt,
                LocalDateTime.now());
    }
}

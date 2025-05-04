package core.basesyntax;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int randomDuration = new Random().nextInt(200);
        Thread.sleep(randomDuration);
        Duration millis = Duration.ofMillis(randomDuration);
        String timeOfFinishing = LocalDateTime.now().plus(millis)
                .format(DateTimeFormatter.ISO_LOCAL_TIME);
        return String.format("Task duration was %s ms, execution finished at %s",
                randomDuration, timeOfFinishing);
    }
}

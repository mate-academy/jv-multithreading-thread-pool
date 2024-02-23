package core.basesyntax;

import java.security.SecureRandom;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private static final String s = "Task duration was %s ms, execution finished at %s";
    private final SecureRandom random = new SecureRandom();
    @Override
    public String call() throws InterruptedException {
        // write your code here

        long start = System.currentTimeMillis();
        int duration = random.nextInt(5);
        Thread.sleep(duration * 100 + 100);
        long end = System.currentTimeMillis();
        String res = String.format(s,end - start, LocalTime.now());
        return res;
    }
}

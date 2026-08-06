package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    private Random random = new Random();

    @Override
    public String call() throws InterruptedException {
        long min = 100; // Мінімальне значення діапазону
        long max = 600; // Максимальне значення діапазону (не включно)
        long randomNumber = min + (long)(random.nextDouble() * (max - min));
        Thread.sleep(randomNumber);
        return String.format("INFO core.basesyntax.Main:24"
                + " Task duration was %d ms, execution finished at %s",
                randomNumber, LocalTime.now());
    }
}

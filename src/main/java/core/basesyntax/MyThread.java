package core.basesyntax;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        int duration = getRandomTimeSleep();
        String time = LocalTime.now().toString();
        String result = String.format(
                        "Task duration was %s ms, "
                        + "execution finished at %s",
                        duration,
                        time
        );
        return result;
    }

    private int getRandomTimeSleep() {
        int[] values = {100, 200, 300, 400, 500};
        Random random = new Random();

        int randomIndex = random.nextInt(values.length);
        int randomValue = values[randomIndex];

        return randomValue;
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

public class MyThread implements Callable<String> {
    @Override
    public String call() throws InterruptedException {
        Date startDate = Calendar.getInstance().getTime();
        Thread.sleep(200);
        Date endDate = Calendar.getInstance().getTime();
        long taskDuration = endDate.getTime() - startDate.getTime();
        return String.format("Task duration was %d ms, execution finished at %s",
                taskDuration, LocalTime.now().toString());
    }
}

package core.basesyntax;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ArrayList<Callable<String>> tasks = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Callable<String> task = () -> {
                int sleepTime = ThreadLocalRandom.current().nextInt(100, 501);
                Thread.sleep(sleepTime);
                return "Task duration was " + sleepTime + " ms, execution finished at " + LocalTime.now();
            };
            tasks.add(task);
        }

        List<Future<String>> futures = executorService.invokeAll(tasks);

        for (Future<String> future : futures) {
            logger.info(future.get());
        }

        executorService.shutdown();
    }
}

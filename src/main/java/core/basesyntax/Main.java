package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 5;
    private static final int TASK_AMOUNT = 20;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<MyThread> tasks = new ArrayList<>();
        for (int i = 0; i < TASK_AMOUNT; i++) {
            tasks.add(new MyThread());
        }

        List<Future<String>> futures = executorService.invokeAll(tasks);
        for (Future<String> task : futures) {
            logger.info(task.get());
        }

        executorService.shutdown();
    }
}

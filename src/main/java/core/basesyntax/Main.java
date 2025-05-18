package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < 20; i++) {
            Callable<String> myTask = new MyThread();
            Future<String> future = executorService.submit(myTask);
            futures.add(future);
        }

        for (Future<String> future : futures) {
            try {
                String result = future.get();
                logger.info(result);
            } catch (InterruptedException | ExecutionException e) {
                logger.error("Task execution failed", e);
            }
        }

        executorService.shutdown();
    }
}

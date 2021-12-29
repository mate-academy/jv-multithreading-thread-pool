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
    private static final int THREADS_COUNT = 5;
    private static final int TASKS_COUNT = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        Callable<String> callableTask = new MyThread();
        for (int i = 0; i < TASKS_COUNT; i++) {
            futures.add(executorService.submit(callableTask));
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Cannot access future data " + future, e);
            }
        }
    }
}

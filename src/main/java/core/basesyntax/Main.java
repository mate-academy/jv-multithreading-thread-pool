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
    private static final int POOL_SIZE = 5;
    private static final int TASKS_COUNT = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE);

        for (int i = 0; i < TASKS_COUNT; i++) {
            futures.add(executorService.submit(new MyThread()));
        }

        executorService.shutdown();

        futures.forEach(future -> {
            try {
                logger.info(future.get());
            } catch (InterruptedException | ExecutionException e) {
                logger.error(e);
            }
        });
    }
}

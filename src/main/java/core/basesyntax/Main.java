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
    private static final int TASK_COUNT = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        try {
            for (int i = 0; i < TASK_COUNT; i++) {
                MyThread task = new MyThread();

                Future<String> future = executor.submit(task);
                futures.add(future);
            }
        } finally {
            executor.shutdown();
        }

        try {
            for (Future<String> future : futures) {
                String result = future.get();

                logger.info(result);
            }
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Помилка під час отримання результату з Future", e);
        }
        // write your code here
    }
}

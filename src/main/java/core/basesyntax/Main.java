package core.basesyntax;

import java.util.Arrays;
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

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        ExecutorService executor = Executors.newFixedThreadPool(2);

        List<Callable<String>> taskList = Arrays.asList(
                new MyThread("Task 1"),
                new MyThread("Task 2"),
                new MyThread("Task 3")
        );

        List<Future<String>> futures = executor.invokeAll(taskList);

        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (ExecutionException e) {
                logger.error("Task execution failed", e);
            }
        }
        executor.shutdown();
    }
}

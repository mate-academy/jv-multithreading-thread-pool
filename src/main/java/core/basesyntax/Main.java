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
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final int THREAD_POOL_SIZE = 5;
    private static final int COUNT_OF_TASKS = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < COUNT_OF_TASKS; i++) {
            futures.add(executorService.submit(new MyThread()));
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            try {
                LOGGER.info(future.get());
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException("Something went wrong!", e);
            }
        }
    }
}

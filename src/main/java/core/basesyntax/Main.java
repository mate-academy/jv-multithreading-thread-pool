package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();

        // Create an ExecutorService with a fixed thread pool of 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Add 20 instances of MyThread to the ExecutorService
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(new MyThread()));
        }

        // Shut down the executor service
        executorService.shutdown();

        // Log the result from each Future
        for (Future<String> future : futures) {
            try {
                String result = future.get();
                logger.info(result);
            } catch (Exception e) {
                logger.error("Error while executing task", e);
            }
        }
    }
}
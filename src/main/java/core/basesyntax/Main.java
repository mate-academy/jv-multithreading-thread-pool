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
    private static final int THREADS_NUMBER = 5;
    private static final int NUMBER_OF_EXECUTIONS = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
            for (int i = 0; i < NUMBER_OF_EXECUTIONS; i++) {
                futures.add(executorService.submit(new MyThread()));
            }

            for (Future<String> future : futures) {
                logger.info(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("Error while executing threads", e);
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }
}

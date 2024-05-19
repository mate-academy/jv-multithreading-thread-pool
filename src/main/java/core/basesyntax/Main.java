package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            MyThread myThread = new MyThread((new Random().nextInt(1000) + 100));
            Future<String> future = executorService.submit(myThread);
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
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                logger.warn("Executor did not terminate in the specified time.");
                List<Runnable> droppedTasks = executorService.shutdownNow();
                logger.warn("Executor was abruptly shut down. {} tasks will not be executed.",
                        droppedTasks.size());
            }
        } catch (InterruptedException e) {
            logger.error("Termination interrupted", e);
            executorService.shutdownNow(); // Форсированное завершение при ошибке
        }

    }
}

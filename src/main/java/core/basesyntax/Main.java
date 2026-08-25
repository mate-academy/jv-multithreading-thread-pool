package core.basesyntax;

import static java.util.concurrent.Executors.newFixedThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            Future<String> future = executorService.submit(new MyThread());
            futures.add(future);
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            try {
                String result = future.get();
                logger.info(result);
            } catch (Exception e) {
                logger.error("Error occurred while executing task", e);
            }
        }

    }
}

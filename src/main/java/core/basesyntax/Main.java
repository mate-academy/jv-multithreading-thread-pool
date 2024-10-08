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
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Future<String> future = executorService.submit(new MyThread());
            futures.add(future);
        }

        for (Future<String> future : futures) {
            try {
                String result = future.get();
                logger.info(result);
            } catch (Exception e) {
                logger.error("Error occurred while getting the result of a task", e);
            }
        }
        executorService.shutdown();
    }
}

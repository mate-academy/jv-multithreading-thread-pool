package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final int THREAD_COUNT = 5;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Future<String> future = executorService.submit(new MyThread());
            futures.add(future);
        }
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (Exception e) {
                logger.error(e);
            }
        }
        executorService.shutdown();
    }
}

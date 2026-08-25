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
        // write your code here
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(new MyThread()));
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

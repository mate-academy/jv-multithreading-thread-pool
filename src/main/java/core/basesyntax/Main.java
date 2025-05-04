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
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Future<String> future = executor.submit(new MyThread());
            futures.add(future);
        }

        futures.forEach(future -> {
            try {
                logger.info(future.get());
            } catch (Exception e) {
                logger.error("Failed to get the future result", e);
            }
        });

        executor.shutdown();
    }
}

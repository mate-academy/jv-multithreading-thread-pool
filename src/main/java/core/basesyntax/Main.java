package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
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
            int duration = (new Random().nextInt(5) + 1) * 100;
            Callable<String> callable = new MyThread(duration);
            futures.add(executor.submit(callable));
        }

        executor.shutdown();

        for (Future<String> future : futures) {
            try {
                String result = future.get();
                logger.info("Result: {}", result);
            } catch (Exception e) {
                logger.error("Error while getting result from future: ", e);
            }
        }
    }
}

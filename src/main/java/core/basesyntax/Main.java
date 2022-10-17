package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            futures.add(threadPool.submit(new MyThread(new Random().nextInt(1000))));
        }
        threadPool.shutdown();
        try {
            for (Future<String> future : futures) {
                logger.info(future.get());
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }
}

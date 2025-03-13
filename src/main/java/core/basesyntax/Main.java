package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<String> callable = new MyThread();
        for (int i = 0; i < 20; i++) {
            futures.add(executor.submit(callable));
        }
        executor.shutdown();

        for (Future<String> future : futures) {
            try {
                String s = future.get();
                logger.info(s);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

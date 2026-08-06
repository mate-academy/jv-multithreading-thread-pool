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
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futures.add(executor.submit(new MyThread()));
        }

        futures.forEach(f -> {
            try {
                logger.info(f.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        executor.shutdown();
    }
}

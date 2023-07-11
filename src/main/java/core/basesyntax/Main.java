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
    private static final String MESSAGE = "%20s, Thread # %2s, counter value %2d";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(new MyThread()));
        }
        for (Future<String> f: futures) {
            try {
                logger.info(f.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("something went wrong");
            }
        }
        executorService.shutdown();
    }
}

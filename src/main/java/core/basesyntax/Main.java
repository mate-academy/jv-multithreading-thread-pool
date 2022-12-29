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
    private static final int THREADS_NUMBER = 5;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        // write your code here
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_NUMBER);
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(new MyThread()));
        }
        executorService.shutdown();
        for (Future<String> future : futures) {
            String s;
            try {
                s = future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Error during execution", e);
            }
            logger.info(s);
        }
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        try {
            for (int i = 1; i <= 20; i++) {
                MyThread task = new MyThread(i);
                Future<String> future = executorService.submit(task);
                futures.add(future);
            }
            for (Future<String> future : futures) {
                try {
                    String result = future.get();
                    logger.log(Level.INFO, result);
                } catch (Exception e) {
                    logger.log(Level.ERROR,"Error occurred while waiting for task completion: "
                            + e.getMessage());
                }
            }
        } finally {
            executorService.shutdown();
        }
    }
}

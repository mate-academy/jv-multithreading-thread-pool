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

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyThread myThread = new MyThread();
        for (int i = 0; i < 20; i++) {
            futures.add(executorService.submit(myThread));
        }
        executorService.shutdown();
        try {
            for (Future future : futures) {
                logger.info(future.get());
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException("Can't add logs");
        }
    }
}

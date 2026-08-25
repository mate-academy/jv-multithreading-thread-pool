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
    private static ExecutorService executor = Executors.newFixedThreadPool(5);
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            MyThread myThread = new MyThread();
            Future<String> result = (Future<String>) executor.submit(myThread);
            futures.add(result);
        }

        for (Future<String> future : futures) {
            String result2 = future.get();
            logger.info(result2);
        }

        executor.shutdown();
    }
}

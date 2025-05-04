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

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<MyThread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            threads.add(new MyThread());
        }
        futures.addAll(executorService.invokeAll(threads));
        executorService.shutdown();
        for (Future<String> future : futures) {
            logger.info(future.get());
        }
    }
}

package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
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
        Callable<String> callable = new MyThread();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            futures.add(service.submit(callable));
        }
        service.shutdown();
        try {
            for (Future<String> future : futures) {
                String s = future.get();
                logger.info(s);
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException("sss");
        }

    }
}

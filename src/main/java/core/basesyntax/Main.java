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
    private static final int THREADS_NUMBER = 20;

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < THREADS_NUMBER; i++) {
            Future<String> future = service.submit(new MyThread());
            futures.add(future);
        }
        service.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Some exception happened!", e);
            }
        }
    }
}

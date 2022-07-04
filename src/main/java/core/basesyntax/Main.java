package core.basesyntax;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        List<Future<String>> futures = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            Future<String> submit = service.submit(new MyThread());
            futures.add(submit);
        }
        service.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.log(Level.INFO, future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Something went wrong...", e);
            }
        }
    }
}

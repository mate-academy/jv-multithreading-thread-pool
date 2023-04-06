package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<String>> futures = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            MyThread thread = new MyThread(random.nextInt(500) + 100);
            Future<String> future = service.submit(thread);
            futures.add(future);
        }
        service.shutdown();
        for (Future<String> future : futures) {
            try {
                logger.info(future.get());
            } catch (Exception e) {
                throw new RuntimeException("Can't get future");
            }
        }
    }
}

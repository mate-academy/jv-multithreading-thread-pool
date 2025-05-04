package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Random random = new Random();
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int duration = random.nextInt(100) + 100;
            MyThread thread = new MyThread(duration);
            Future<String> future = executorService.submit(thread);
            futures.add(future);
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }
}

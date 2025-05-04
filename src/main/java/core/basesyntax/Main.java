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
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Callable<String> myThread = new MyThread();
            Future<String> future = executorService.submit(myThread);
            futures.add(future);
        }

        executorService.shutdown();

        for (Future<String> future : futures) {
            try {
                System.out.println("INFO core.basesyntax.Main:24 " + future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException();
            }
        }
    }
}

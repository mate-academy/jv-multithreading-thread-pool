package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var futures = new ArrayList<Future<String>>();
        var executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            Future<String> result = executor.submit(new MyThread());
            futures.add(result);
        }

        executor.shutdown();

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
    }
}

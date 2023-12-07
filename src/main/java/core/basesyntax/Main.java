package core.basesyntax;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        IntStream.range(0, 20)
                .forEach(i -> CompletableFuture.supplyAsync(() -> {
                    try {
                        return myThread.call();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }, executor)
                        .thenAccept(logger::info));
        executor.shutdown();
    }
}

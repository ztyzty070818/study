package guava.collections.immutable;

import java.util.*;
import java.util.concurrent.*;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        System.out.println(executorService.isShutdown());

        executorService.submit(() -> {
            System.out.println("1");
            System.out.println(Thread.currentThread().getName() + " sleep");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1 wake up");
        });

        System.out.println(executorService.isShutdown());
    }
}

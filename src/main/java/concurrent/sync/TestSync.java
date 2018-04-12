package concurrent.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestSync {

    private static final int THREAD_COUNT = 2000;

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        TestSync testSync = new TestSync();

        for(int i=0; i<THREAD_COUNT; i++) {
            executorService.submit(
                    () -> {
                        for(int j=0; j<10; j++) {
                            testSync.incrementCount();
                        }
                    }
            );
        }
        executorService.shutdown();
    }



    private static int count = 0;

    private final Object lock = new Object();

    private void incrementCount() {
        synchronized (lock) {
            count++;
        }
        System.out.println(count);
    }

}

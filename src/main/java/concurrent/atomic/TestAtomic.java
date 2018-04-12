package concurrent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAtomic {

    public static int count = 0;
    public static AtomicInteger atomicCount = new AtomicInteger(0);
    public static final int THREAD_COUNT = 2000;

    public static void main(String[] args) {
        testIncrement();
//        testAtomicIncrement();
    }

    public static void testIncrement() {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for(int i=0; i<THREAD_COUNT; i++) {
            executorService.submit(
                    () -> {
                        for(int j=0; j<10; j++) {
                            count = count + 1;
                            System.out.println(count);
                        }
                    }
            );
        }

        executorService.shutdown();
    }

    public static void testAtomicIncrement() {

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        for(int i=0; i<THREAD_COUNT; i++) {
            executorService.submit(
                    () -> {
                        for(int j=0; j<10; j++) {
                            atomicCount.incrementAndGet();
                            System.out.println(atomicCount);
                        }
                    }
            );
        }

        executorService.shutdown();
    }
}

package executor;

import com.google.common.util.concurrent.*;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.concurrent.*;

public class TestExecutor {
    public static void main(String[] args) throws Exception {

        test2();

    }

    public static void test1() throws Exception {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        final ListenableFuture<Integer> listenableFuture = executorService.submit(
                () -> {
                    System.out.println("call execute..");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("finish execute..");
                    return 7;
                }
        );

        listenableFuture.addListener(
                () -> {
                    try {
                        System.out.println("get listenable future's result " + listenableFuture.get());
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                },
                executorService
        );

    }

    public static void test2() throws Exception {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        final ListenableFuture<Integer> listenableFuture = executorService.submit(
                () -> {
                    System.out.println("call execute..");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("finish execute..");
                    return 7;
                }
        );

        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("fail");
                t.printStackTrace();
            }
        });

    }

    public static void test3() throws Exception {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        final ListenableFuture<Integer> listenableFuture = executorService.submit(
                () -> {
                    System.out.println("call execute..");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("finish execute..");
                    return 7;
                }
        );

    }

}

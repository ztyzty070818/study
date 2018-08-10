package google.guava.future;

import com.google.common.util.concurrent.*;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class TestFuture {

    ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

    ListenableFuture future1 = service.submit(new Callable<Integer>() {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            System.out.println("call future 1.");
            return 1;
        }
    });

    ListenableFuture future2 = service.submit(new Callable<Integer>() {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            System.out.println("call future 2.");
            return 2;
        }
    });

    final ListenableFuture allFutures = Futures.allAsList(future1, future2);

//    final ListenableFuture transform = Futures.transform(allFutures, new AsyncFunction<>() {
//        @Override
//        public ListenableFuture apply(Object input) throws Exception {
//            return null;
//        }
//    })
}

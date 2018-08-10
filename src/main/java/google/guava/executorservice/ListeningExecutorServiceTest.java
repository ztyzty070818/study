package google.guava.executorservice;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;

/**
 * Created by zty on 18-8-10
 */
public class ListeningExecutorServiceTest {
	public static void main(String[] args) {
		ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

		for(int i = 0; i< 50 ; i++) {
			ListenableFuture<?> listenableFuture = listeningExecutorService.submit(()-> {
				System.out.println(2);
			});
		}
	}
}

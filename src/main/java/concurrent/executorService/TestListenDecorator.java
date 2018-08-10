package concurrent.executorService;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Executors;

/**
 * Created by zty on 18-7-2
 */
public class TestListenDecorator {
	public static void main(String[] args) {
		ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));

	}
}

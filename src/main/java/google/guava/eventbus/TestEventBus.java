package google.guava.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * Created by zty on 18-8-14
 */
public class TestEventBus {
	public static void main(String[] args) {
		EventBus eventBus = new EventBus("test");

		EventListener listener = new EventListener();

		eventBus.register(listener);

		eventBus.post(new TestEvent(10));

		eventBus.post(new TestEvent(100));

		eventBus.post(new TestEvent(1000));

		eventBus.post(10000);

		eventBus.post(10000L);
	}
}

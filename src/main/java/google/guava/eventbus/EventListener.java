package google.guava.eventbus;

import com.google.common.eventbus.Subscribe;

/**
 * Created by zty on 18-8-14
 */
public class EventListener {
	public int lastMessage = 0;

	@Subscribe
	public void listen(TestEvent event) {
		lastMessage = event.getMessage();
		System.out.println("Event listener: " + lastMessage);
	}

	@Subscribe
	public void listenInt(Integer i) {
		System.out.println("Event integer: " + i);
	}

	@Subscribe
	public void listenLong(Long l) {
		System.out.println("Event long: " + l);
	}

	public int getLastMessage() {
		return lastMessage;
	}
}

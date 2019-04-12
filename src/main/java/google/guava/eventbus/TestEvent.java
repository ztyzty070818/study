package google.guava.eventbus;

/**
 * Created by zty on 18-8-14
 */
public class TestEvent {
	private final int message;

	public TestEvent(int message) {
		this.message = message;
		System.out.println("Event message: " + message);
	}

	public int getMessage() {
		return message;
	}
}

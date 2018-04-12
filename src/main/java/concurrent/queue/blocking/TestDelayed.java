package concurrent.queue.blocking;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestDelayed implements Delayed{

    private long expired;
    private long delay;
    private String name;

    TestDelayed(String elementName, long delay) {
        this.name = elementName;
        this.delay = delay;
        expired = (delay + System.currentTimeMillis());
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return delay;
    }

    public long getExpired() {
        return expired;
    }

    @Override
    public int compareTo(Delayed o) {
        TestDelayed delayed = (TestDelayed)o;
        return delayed.getExpired() > expired ? 1:-1;
    }

    @Override
    public String toString() {
        return String.format("TestDelayed [delay=%d, name=%s]", delay, name);
    }

    public static void main(String[] args) {
        TestDelayed delayed = new TestDelayed("delay1", 3000);
        System.out.println(delayed);
    }


}

package concurrent.queue.blocking;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestArrayBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);
        for(int i=0; i<3; i++) {
            queue.add(i);
            System.out.println(queue.element());
            System.out.println(queue.peek());
            System.out.println(queue.size());
        }
    }
}

package blockingqueue.delayBlockingQueue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        queue.add(new DelayTask("1", 1000L, TimeUnit.MILLISECONDS));
        queue.add(new DelayTask("2", 2000L, TimeUnit.MILLISECONDS));
        queue.add(new DelayTask("3", 3000L, TimeUnit.MILLISECONDS));

        System.out.println("queue put done");

        while(!queue.isEmpty()) {
            try {
                DelayTask task = queue.take();
                System.out.println(task.name + ":" + System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

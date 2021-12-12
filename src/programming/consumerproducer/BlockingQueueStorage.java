package programming.consumerproducer;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueStorage implements Storage{

    Queue<Object> queue = new LinkedBlockingDeque<>(1);

    @Override
    public void produce(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            queue.offer(new Object());
        }
        System.out.println("Successfully added "+n+" object into list, current size:"+ queue.size());
    }

    @Override
    public void consume(int n) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            queue.poll();
        }
        System.out.println("Successfully consumed "+n+" object from list, current size:"+ queue.size());
    }
}

package programming.consumerproducer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreStorage implements Storage{

    List<Object> list = new LinkedList<>();
    private final Semaphore freeSlot = new Semaphore(1);
    private final Semaphore occupiedSlot = new Semaphore(0);
    private final Semaphore mutex = new Semaphore(1);

    @Override
    //must obtain freeSlot/occupiedSlot before mutex, otherwise it will lead to deadlock (hold mutex but still cannot proceed)
    public void produce(int n) throws InterruptedException {
        freeSlot.acquire(n);
        mutex.acquire();
        try {
            for (int i = 0; i < n; i++) {
                list.add(new Object());
            }
            System.out.println("Successfully added "+n+" object into list, current size:"+ list.size());
        }finally {
            mutex.release();
            occupiedSlot.release(n);
        }
    }

    @Override
    public void consume(int n) throws InterruptedException {
        occupiedSlot.acquire(n);
        mutex.acquire();
        try {
            for (int i = 0; i < n; i++) {
                list.remove(0);
            }
            System.out.println("Successfully consumed "+n+" object from list, current size:"+ list.size());
        }finally {
            mutex.release();
            freeSlot.release(n);
        }
    }
}

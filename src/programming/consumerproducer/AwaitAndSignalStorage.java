package programming.consumerproducer;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitAndSignalStorage implements Storage{

    private final int MAX_SIZE = 1;
    List<Object> list = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition isFull = lock.newCondition();
    private final Condition isEmpty = lock.newCondition();

    @Override
    public void produce(int n) throws InterruptedException {
        lock.lock();
        try{
            while ((list.size() + n) > MAX_SIZE){
                System.out.println("Container full..waiting for consumer process..");
                isFull.await();
            }

            for (int i = 0; i < n; i++) {
                list.add(new Object());
            }
            System.out.println("Successfully added "+n+" object into list, current size:"+ list.size());

            isEmpty.signal();
        }finally {
            lock.unlock();
        }

    }

    @Override
    public void consume(int n) throws InterruptedException {
        lock.lock();
        try{
            while ((list.size() - n) < 0){
                System.out.println("Container is empty..waiting for producer process..");
                isEmpty.await();
            }

            for (int i = 0; i < n; i++) {
                list.remove(0);
            }
            System.out.println("Successfully consumed "+n+" object from list, current size:"+ list.size());

            isFull.signal();
        }finally {
            lock.unlock();
        }
    }
}

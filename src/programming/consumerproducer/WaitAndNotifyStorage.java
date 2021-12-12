package programming.consumerproducer;

import java.util.LinkedList;
import java.util.List;


public class WaitAndNotifyStorage implements Storage{

    private final int MAX_SIZE = 1;
    List<Object> list = new LinkedList<>();

    @Override
    //synchronized function without wait will keep the lock forever
    //notify/wait must be used after obtaining object's lock, otherwise will get current thread is not owner exception
    public void produce(int n) throws InterruptedException {
        synchronized (list){
            while (list.size() + n > MAX_SIZE){
                System.out.println("Container full..waiting for consumer process..");
                list.wait();
            }

            for (int i = 0; i < n; i++) {
                list.add(new Object());
            }
            System.out.println("Successfully added "+n+" object into list, current size:"+ list.size());
            list.notifyAll();
        }
    }

    @Override
    public void consume(int n) throws InterruptedException {
        synchronized (list){
            while (list.size() - n < 0){
                System.out.println("Container is empty..waiting for producer process..");
                list.wait();
            }

            for (int i = 0; i < n; i++) {
                list.remove(0);
            }

            System.out.println("Successfully consumed "+n+" object from list, current size:"+ list.size());
            list.notifyAll();
        }
    }
}

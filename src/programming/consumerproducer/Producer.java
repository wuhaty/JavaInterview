package programming.consumerproducer;

public class Producer implements Runnable{

    Storage storage;

    Producer(Storage s) {
        this.storage = s;
    }


    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                storage.produce(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

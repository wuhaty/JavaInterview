package programming.consumerproducer;

public class Consumer implements Runnable {

    Storage storage;

    Consumer(Storage s){
        this.storage = s;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                storage.consume(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

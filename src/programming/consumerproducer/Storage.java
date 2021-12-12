package programming.consumerproducer;

public interface Storage {

    public void produce(int n) throws InterruptedException;

    public void consume(int n) throws InterruptedException;
}

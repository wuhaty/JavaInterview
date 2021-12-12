package programming.consumerproducer;

public class Test {
    public static void main(String[] args) {
        Storage s = new SemaphoreStorage();
        Producer p1 = new Producer(s);
        Producer p2 = new Producer(s);
        Producer p3 = new Producer(s);
        Producer p4 = new Producer(s);
        Producer p5 = new Producer(s);

        Consumer c1 = new Consumer(s);
        Consumer c2 = new Consumer(s);
        Consumer c3 = new Consumer(s);
        Consumer c4 = new Consumer(s);
        Consumer c5 = new Consumer(s);


        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p1);
        Thread t3 = new Thread(p1);
        Thread t4 = new Thread(p1);
        Thread t5 = new Thread(p1);

        Thread ct1 = new Thread(c1);
        Thread ct2 = new Thread(c2);
        Thread ct3 = new Thread(c3);
        Thread ct4 = new Thread(c4);
        Thread ct5 = new Thread(c5);

        t1.start();
        t2.start();
//        t3.start();
//        t4.start();
//        t5.start();
        ct1.start();
        ct2.start();
//        ct3.start();
//        ct4.start();
//        ct5.start();
    }
}

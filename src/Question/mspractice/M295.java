package Question.mspractice;

import java.util.PriorityQueue;

public class M295 {

    PriorityQueue<Integer> smaller;
    PriorityQueue<Integer> larger;

    public static void main(String[] args) {
        M295 m = new M295();
        m.addNum(40);
        m.addNum(12);
        m.addNum(16);
        m.findMedian();
    }


    public M295() {
        smaller = new PriorityQueue<>((o1,o2) -> o2-o1);
        larger = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (smaller.size() == larger.size()){
            if (smaller.isEmpty() || num <= larger.peek()){
                smaller.offer(num);
            }else {
                smaller.offer(larger.poll());
                larger.offer(num);
            }
        }else {
            if (num < smaller.peek()){
                larger.offer(smaller.poll());
                smaller.offer(num);
            }else {
                larger.offer(num);
            }
        }
    }

    public double findMedian() {
        if (smaller.size() != larger.size()){
            return smaller.peek();
        }else {
            return (smaller.peek() + larger.peek())/2.0;
        }
    }
}

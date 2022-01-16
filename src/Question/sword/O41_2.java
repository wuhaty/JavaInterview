package Question.sword;

import java.util.Comparator;
import java.util.PriorityQueue;

public class O41_2 {

    PriorityQueue<Integer> l;
    PriorityQueue<Integer> r;
    public static void main(String[] args) {
        O41_2 q= new O41_2();
        q.addNum(-1);
        q.findMedian();
        q.addNum(-2);
        q.findMedian();
        q.addNum(-3);
        q.findMedian();
        q.addNum(-4);
        q.findMedian();
        q.addNum(-5);
        q.findMedian();
    }
    /** initialize your data structure here. */
    public O41_2() {
        l = new PriorityQueue<>(Comparator.reverseOrder());
        r = new PriorityQueue<>(Integer::compareTo);
    }

    public void addNum(int num) {
        if (l.size() != r.size()) {
            if (num >= l.peek()){
                r.offer(num);
            }else {
                r.offer(l.poll());
                l.offer(num);
            }
        }else {
            if (r.isEmpty() || num<=l.peek()){
                l.offer(num);
            }else {
                r.offer(num);
                l.offer(r.poll());
            }
        }
    }

    public double findMedian() {
        int size = (l.size() + r.size());
        if (size % 2 == 0){
            return (l.peek()+r.peek())/2.0;
        }else {
            return l.peek();
        }
    }
}

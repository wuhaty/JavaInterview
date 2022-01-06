package Question.sword;

import java.util.PriorityQueue;

public class O41 {

    PriorityQueue<Integer> lower= null;
    PriorityQueue<Integer> higher= null;

    public O41() {
        lower= new PriorityQueue<>((x,y)-> y-x);
        higher= new PriorityQueue<>();
    }

    public static void main(String[] args) {
        O41 q= new O41();
        q.addNum(1);
        q.addNum(2);
        q.findMedian();
        q.addNum(3);
        q.findMedian();
    }

    public void addNum(int num) {
        if (lower.size() != higher.size()){
            if (num >= higher.peek()){
                lower.offer(higher.poll());
                higher.offer(num);
            }else {
                lower.offer(num);
            }
        }else {
            if (higher.isEmpty() || num >= higher.peek()){
                higher.offer(num);
            }else {
                lower.offer(num);
                higher.offer(lower.poll());
            }
        }
    }

    public double findMedian() {
        if (lower.size() == higher.size()){
            return (lower.peek() + higher.peek())/2.0;
        }else {
            return higher.peek();
        }
    }
}

package Question.sword;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class O59_2 {

    Queue<Integer> q;
    Deque<Integer> max;

    public O59_2() {
        q = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) {
            return -1;
        }

        return max.peekFirst();
    }

    public void push_back(int value) {
        while (!max.isEmpty() && max.peekLast() < value){
            max.pollLast();
        }
        max.offerLast(value);
        q.offer(value);
    }

    public int pop_front() {
        if (q.isEmpty()) {
            return -1;
        }
        if (max.peekFirst().equals(q.peek())){
            max.pollFirst();
        }
        return  q.poll();
    }
}

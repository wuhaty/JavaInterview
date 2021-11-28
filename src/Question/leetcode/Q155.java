package Question.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q155 {

    List<Integer> l = null;
    List<Integer> minStack = null;
    public Q155() {
        l = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        l.add(l.size(),val);
        minStack.add(minStack.size(),Math.min(minStack.get(minStack.size()-1),val));
    }

    public void pop() {
        l.remove(l.size()-1);
        minStack.remove(l.size()-1);
    }

    public int top() {
        return l.get(l.size()-1);
    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}

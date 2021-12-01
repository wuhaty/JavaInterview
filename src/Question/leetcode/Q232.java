package Question.leetcode;

import java.util.Stack;

public class Q232 {

    Stack<Integer> s1 = null;
    Stack<Integer> s2 = null;
    Integer peek;
    public Q232() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        if (s1.isEmpty()) peek = x;
        s1.push(x);
    }

    public int pop() {
        if (s2.isEmpty()){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (!s2.isEmpty()) return s2.peek();
        return peek;
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

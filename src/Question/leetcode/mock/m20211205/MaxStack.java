package Question.leetcode.mock.m20211205;

import java.util.Stack;

public class MaxStack {

    Stack<Integer> s;
    Stack<Integer> ms;


    public MaxStack() {
        s = new Stack<>();
        ms = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        ms.push(Math.max(x,ms.isEmpty()?0:ms.peek()));
    }

    public int pop() {
        ms.pop();
        return s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int peekMax() {
        return ms.peek();
    }

    public int popMax() {
        int max = ms.peek();

        Stack<Integer> t = new Stack<>();
        while (s.peek() != max) {
            pop();
            t.push(s.pop());
        }
        s.pop();
        ms.pop();
        while (!t.isEmpty()) {
            push(t.pop());
        }
        return max;
    }
}

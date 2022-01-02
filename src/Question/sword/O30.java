package Question.sword;

import java.util.Stack;

public class O30 {

    Stack<Integer> s;
    Stack<Integer> min;

    public O30() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        s.push(x);

        if (min.isEmpty() || min.peek()>x) {
            min.push(x);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        s.pop();
        min.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return min.peek();
    }
}

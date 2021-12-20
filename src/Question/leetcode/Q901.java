package Question.leetcode;

import java.util.Stack;

public class Q901 {
    Stack<Integer> s;
    Stack<Integer> w;
    public Q901() {
        s = new Stack<>();
        w = new Stack<>();
    }

    public int next(int price) {
        int res = 1;

        while (!s.isEmpty() && s.peek() <= price) {
            res+=w.pop();
            s.pop();
        }

        w.push(res);
        s.push(price);
        return res;
    }
}

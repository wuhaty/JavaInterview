package Question.leetcode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by gump on 2017/5/6.
 */
public class Q20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char input[] = s.toCharArray();
        int i = 0;
        while (i < input.length) {
            if (stack.isEmpty() || !inPair(stack.peek(), input[i])) {
                stack.push(input[i]);
            } else {
                stack.pop();
            }
            i++;
        }
        return stack.isEmpty();
    }

    private boolean inPair(char peek, char c) {
        return Math.abs(peek - c) == 1 || Math.abs(peek - c) == 2;
    }

    public boolean isValid2021(String s) {
        char cs[] = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '[' || cs[i] == '(' || cs[i] == '{') {
                stack.push(cs[i]);
                continue;
            } else {
                if (stack.isEmpty()) return false;

                char c = stack.peek();
                if ((c == '[' && cs[i] == ']')
                        || (c == '{' && cs[i] == '}')
                        || (c == '(' && cs[i] == ')')) {
                    stack.pop();
                    continue;
                }else {
                    return false;
                }
            }

        }
        return stack.size()==0;
    }
}

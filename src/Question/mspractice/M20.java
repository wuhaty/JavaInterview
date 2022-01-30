package Question.mspractice;

import java.util.Stack;

public class M20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (cs[i] == '(' || cs[i] == '{' || cs[i] == '['){
                stack.push(cs[i]);
            }else {
                if (stack.isEmpty()) return false;
                char top = stack.peek();
                if ((top == '(' && cs[i] == ')')
                    || (top == '{' && cs[i] == '}')
                    || (top == '[' && cs[i] == ']')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

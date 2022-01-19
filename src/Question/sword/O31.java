package Question.sword;

import java.util.Stack;

public class O31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        Stack<Integer> s = new Stack<>();

        while (i < pushed.length){
            s.push(pushed[i]);

            while (!s.isEmpty() &&s.peek() == popped[j]){
                j++;
                s.pop();
            }
            i++;
        }

        return s.isEmpty();
    }
}

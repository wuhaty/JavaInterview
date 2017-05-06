package Question.leetcode;

import java.util.LinkedList;

/**
 * Created by gump on 2017/5/6.
 */
public class Q20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char input[] = s.toCharArray();
        int i = 0;
        while (i<input.length){
            if(stack.isEmpty() || !inPair(stack.peek(),input[i])){
                stack.push(input[i]);
            }else{
                stack.pop();
            }
            i++;
        }
        return stack.isEmpty();
    }

    private boolean inPair(char peek, char c) {
        return Math.abs(peek-c) == 1 || Math.abs(peek-c) == 2;
    }
}

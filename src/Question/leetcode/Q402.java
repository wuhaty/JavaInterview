package Question.leetcode;

import java.util.Stack;

/**
 * Created by gump on 2018/1/15.
 */
public class Q402 {

    public static void main(String argc[]){
        Q402 q = new Q402();
        q.removeKdigits("10",2);
    }



    public String removeKdigits(String num, int k) {
        Stack<Character> s =new Stack<>();
        char res[] = new char[num.length()-k];
        if (num.length()-k==0) return "0";
        char ch[] = num.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            while (!s.isEmpty() && s.peek()>ch[i] && k>0){
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }

        int start = 0;
        while (start<s.size() && s.get(start)=='0') start++;
        int temp = start;
        int i = 0;
        while (i<res.length && start<s.size()) res[i++] = s.get(start++);

        String result = new String(res,0,res.length-temp);
        return result.isEmpty()?"0":result;
    }
}

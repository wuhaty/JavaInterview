package Question.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by gump on 2018/1/15.
 */
public class Q402 {

    public static void main(String argc[]){
        Q402 q = new Q402();
        q.removeKdigits("10",2);
    }

    public String removeKdigits2021(String num, int k) {
        StringBuilder sb = new StringBuilder(num);

        if (k==sb.length()){
            return "0";
        }

        for (int i = 0; i < k; i++) {
            int j = 1;
            for (; j < sb.length()-1; j++) {
                if (sb.charAt(j)< sb.charAt(j-1)) break;
            }
            sb.deleteCharAt(j-1);
        }

        while (sb.charAt(0)=='0' && sb.length()>=1){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }

    public String removeKdigitsStack(String num, int k) {
        Deque<Integer> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); i++) {
            int digit = (num.charAt(i)-'0');

            while (k>0 && stack.peekLast() > digit){
                k--;
                stack.pollLast();
            }
            stack.offerLast(digit);
        }

        for (int i = 0; i < k; i++) {
            stack.pollLast();
        }


        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        while (!stack.isEmpty()){
            int d = stack.pollFirst();
            if (leadingZero && d == 0){
                continue;
            }
            sb.append(d);
        }

        return sb.length() == 0?"0":sb.toString();
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

package Question.leetcode;

import java.util.Stack;

/**
 * Created by gump on 2017/5/8.
 */
public class Q227 {
    public static void main(String argc[]){
        Q227 q= new Q227();
        System.out.println(q.calculate("5   "));
    }

    public int calculate(String s) {
       Stack<Integer> stack = new Stack<>();
       int len = s.length();
       int num = 0;
       char sign = '+';

       for (int i = 0; i < len; i++) {
           if(s.charAt(i)>='0' && s.charAt(i)<='9'){
               num = (num*10)+s.charAt(i)-'0';
           }

           if(((s.charAt(i)<'0' || s.charAt(i)>'9' ) && s.charAt(i) != ' ')
                   || i==len-1){
               if (sign =='+'){
                   stack.push(num);
               }else if (sign =='-'){
                   stack.push(-num);
               }else if (sign =='*'){
                   stack.push(stack.pop()*num);
               }else if (sign =='/'){
                   stack.push(stack.pop()/num);
               }
               num = 0;
               sign = s.charAt(i);
           }
       }
        int result = 0;
        for (int i :stack) {
            result+=i;
        }
        return result;
    }
}

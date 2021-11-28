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

    public int calculate2021(String s) {
        Stack<Integer> stack = new Stack<>();

        char cs[] = s.toCharArray();

        int n1 = 0;
        char preOp = '+';
        for (int i = 0; i < cs.length; i++) {
              char c = cs[i];
              if (c>='0'& c<='9'){
                  n1 = (n1*10+(c-'0'));
              }

              if (c=='+'||c=='-'||c=='*'||c=='/' || i==cs.length-1){
                  if (preOp=='+'){
                      stack.push(n1);
                  }else if(preOp=='-'){
                      stack.push(-n1);
                  }else if (preOp=='*'){
                      stack.push(stack.pop()*n1);
                  }else if (preOp=='/'){
                      stack.push(stack.pop()/n1);
                  }
                  n1 = 0;
                  preOp = c;
              }
        }

        int res = 0;
        while (!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}

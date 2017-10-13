package Question.leetcode.weeklyContest;

import java.util.Stack;

/**
 * Created by gump on 2017/9/24.
 */
public class W51Q682 {

    public static void main(String argc[]){
        W51Q682 q= new W51Q682();
        String[] ops = {"5","2","C","D","+"};
        System.out.println(q.calPoints(ops));
    }


    public int calPoints(String[] ops) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for (String op:ops) {
            try {
                int score = Integer.parseInt(op);
                sum+=score;
                s.push(score);
            }catch (NumberFormatException e){
                Character c = op.charAt(0);
                if (c == 'C'){
                    int temp = s.pop();
                    sum -= temp;
                }else if (c=='D'){
                    sum+=(2*s.peek());
                    s.push(2*s.peek());
                }else{
                    int a = s.peek();
                    int b = s.get(s.size()-2);
                    s.push(a+b);
                    sum += (a+b);
                }
            }
        }
        return sum;
    }
}

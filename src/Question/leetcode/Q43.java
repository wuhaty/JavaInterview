package Question.leetcode;

/**
 * Created by gump on 2017/4/21.
 */
public class Q43 {
    public String multiply(String num1, String num2) {
        int result[] = new int[num1.length()+num2.length()];


        for (int i = num1.length()-1; i >=0 ; i--) {
            for (int j = num2.length()-1; j >=0 ; j--) {
                result[i+j+1] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
            }
        }

        int adder =0;

        for (int i = result.length-1; i >=0 ; i--) {
            int temp =(result[i]+adder);
            result[i] = temp%10 ;
            adder = temp /10;
        }

        StringBuilder sb = new StringBuilder();
        for (int i:result) {
            sb.append(i);
        }
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String argc[]){
        Q43 q = new Q43();
        System.out.println(q.multiply("9","99"));
    }
}

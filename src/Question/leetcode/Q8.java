package Question.leetcode;

/**
 * Created by gump on 2017/5/7.
 */
public class Q8 {

    public static void main(String argc[]){
        Q8 q =new Q8();
        System.out.println(q.myAtoi("2147483648"));
    }




    public int myAtoi(String str) {
        if(str==null || str.isEmpty()) return 0;
        char input[] = str.toCharArray();

        int i =0;
        boolean isNeg = false;
        while (i<input.length && input[i]==' '){
            i++;
        }

        if(input[i]=='-' || input[i]=='+') {
            if (input[i]=='-') isNeg =true;
            i++;
        }

        if(i>=input.length) return 0;

        int result =0;

        while (i<input.length && input[i]>='0' && input[i] <='9'){
            if((Integer.MAX_VALUE-(input[i]-'0'))/10<result) return isNeg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            result =(result*10 + (input[i]-'0'));
            i++;
        }
        return isNeg?-result:result;
    }
}

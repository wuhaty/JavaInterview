package Question.leetcode;

/**
 * Created by gump on 2017/5/7.
 */
public class Q8 {

    public static void main(String argc[]){
        Q8 q =new Q8();
//        System.out.println(q.myAtoi2021_2("-91283472332"));
//        System.out.println(q.myAtoi2021_2("  -42"));
//        System.out.println(q.myAtoi2021_2("-000000000000001"));
        System.out.println(q.myAtoi2021_2(" "));
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

    public int myAtoi2021(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1;
        int res = 0;
        char[] cs = s.toCharArray();
        int i =0;
        if (cs[0] == '-' || cs[0] == '+') {
            i++;
            if (cs[0] == '-') {
                sign = -1;
            }
        }

        for (; i < cs.length; i++) {
            if (!Character.isDigit(cs[i])){
                return sign * res;
            }


            int n = cs[i] - '0';
            if (res > (Integer.MAX_VALUE/10) ||
                    res > (Integer.MAX_VALUE-n)/10){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }

            res = ((res * 10) + n);
         }

        return sign * res;
    }

    public int myAtoi2021_2(String s) {
        if (s==null || s.isEmpty()) return 0;

        s = s.trim();
        char cs[] = s.toCharArray();
        boolean neg = false;
        int index = 0;
        if (cs.length > 0 && (cs[0] == '-' || cs[0] == '+')) {
            index++;
            neg = (cs[0] == '-');
        }

        int res = 0;

        for (; index < cs.length; index++) {
            if (cs[index] < '0' || cs[index] > '9') return neg?-res:res;

            int input = cs[index]-'0';

            if (!neg && res > (Integer.MAX_VALUE-input)/10) return Integer.MAX_VALUE;
            if (neg && res > (Integer.MAX_VALUE-input)/10) return Integer.MIN_VALUE;

            res = res * 10 + input;
        }

        return neg?-res:res;
    }
}

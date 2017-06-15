package Question.interview.mocked;

/**
 * Created by gump on 2017/6/8.
 */
public class Q7 {

    public static void main(String argc[]){
        Q7 q = new Q7();
        System.out.println(q.reverse(123));
    }

    public int reverse(int x) {
        int result = 0;

        while (x!=0){
            int tail = x % 10;
            int newResult = result * 10 + tail;

            if ((newResult -tail)/10 != result){
                return 0;
            }
            result = newResult;
            x/=10;
        }

        return result;
    }

    public int reverseOri(int x) {
        boolean flag = x<0;

        if (flag) {
            x = -x;
        }

        StringBuilder sb = new StringBuilder(String.valueOf(x));
        StringBuilder result = new StringBuilder();
        if (flag) result.append("-");

        boolean startZero = true;

        for (int i = sb.length()-1; i >=0 ; i--) {
            char c = sb.charAt(i);
            if (startZero && c == '0' && i!=0){
                startZero = true;
                continue;
            }
            startZero = false;
            result.append(c);
        }

        try {
            return Integer.parseInt(result.toString());
        }catch (NumberFormatException e){
            return 0;
        }
    }
}

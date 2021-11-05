package Question.interview.MS;

/**
 * Created by gump on 2021/7/12.
 */
public class Question {

    /*
    * Input : String to util
    *
    *
    * */

    public static int stringToInt(String s) throws Exception {
        if (s==null || s.isEmpty()) {
            throw new Exception("invalid input");
        }

        char[] cs = s.toCharArray();
        Integer res = 0;
        boolean isNeg = false;

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '+') {
                if (i!=0) {
                    throw new Exception("invalid input");
                }
                continue;
            }

            if (cs[i] == '-') {
                if (i!=0) {
                    throw new Exception("invalid input");
                }

                isNeg = true;
                continue;
            }

            if (!Character.isDigit(cs[i])){
                throw new Exception("invalid input");
            }

            //overflow detection
//            long l = (long)res * 10 + (cs[i]-'0');

            if ((res*10 - Integer.MAX_VALUE) > 0
                    || (res * 10 + (cs[i]-'0') - Integer.MAX_VALUE) >0
                    || (isNeg && (-res*10 - Integer.MAX_VALUE) < 0 )
                    || (isNeg && (-(res*10+(cs[i]-'0')) - Integer.MAX_VALUE) < 0 )) {
                throw new Exception("overflow");
            }

//            if ((l-Integer.MAX_VALUE)>0 || (isNeg && (-l- Integer.MIN_VALUE)<0)) {
//                throw new Exception("overflow");
//            }

            res = (res * 10 + (cs[i]-'0'));
        }

        return isNeg? -res:res;
    }


    public static void main(String[] args) throws Exception {
//        System.out.println(Question.stringToInt("0"));
//        System.out.println(Question.stringToInt("-100"));
//        System.out.println(Question.stringToInt("100"));
//        System.out.println(Question.stringToInt("+100"));
//        System.out.println(Question.stringToInt("0100"));
//        System.out.println(Question.stringToInt("123.1"));
//        System.out.println(Question.stringToInt("asdc"));
        System.out.println(Question.stringToInt("9999999999999999"));
//        System.out.println(Question.stringToInt("---"));
//        System.out.println(Question.stringToInt("1-1"));
//        System.out.println(Question.stringToInt("-9999999999999999"));

    }
}

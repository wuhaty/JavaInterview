package Question.mspractice;

public class M8 {
    public static void main(String[] args) {
        M8 m = new M8();
        m.myAtoi("-91283472332");
    }



    public int myAtoi(String s) {
        s = s.trim();
        boolean isNeg = false;
        char[] cs = s.toCharArray();
        int res = 0;

        for (int i = 0; i < cs.length; i++) {
            if (i==0 && (cs[i] == '+' || cs[i] == '-')){
                isNeg = (cs[i] == '-');
            }else if (!Character.isDigit(cs[i])){
                break;
            }else if (Character.isDigit(cs[i])){
                int t = cs[i]-'0';

                if (res > Integer.MAX_VALUE/10){
                    return isNeg? Integer.MIN_VALUE:Integer.MAX_VALUE;
                }else if (res == Integer.MAX_VALUE/10 && t > 7){
                    return isNeg? Integer.MIN_VALUE:Integer.MAX_VALUE;
                }else {
                    res = res *10 +t;
                }
            }
        }

        return isNeg?-res:res;
    }
}

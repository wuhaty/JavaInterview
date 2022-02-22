package Question.mspractice;

public class M8_2 {
    public int myAtoi(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;

        char[] cs = s.toCharArray();
        int p = (cs[0] == '-' || cs[0] == '+') ? 1:0;
        boolean isNeg = cs[0] == '-';
        int res = 0;

        while (p<s.length() && Character.isDigit(cs[p])){
            int x = cs[p++]-'0';

            if (res > (Integer.MAX_VALUE/10)){
                return isNeg? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }else if (res == (Integer.MAX_VALUE/10) && x >=7){
                return isNeg? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            res = res*10 + x;
        }

        return isNeg? -res:res;
    }
}

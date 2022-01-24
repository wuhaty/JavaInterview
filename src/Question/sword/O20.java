package Question.sword;

public class O20 {
    public boolean isNumber(String s) {
        if (s == null) return false;

        char[] cs = s.trim().toCharArray();
        if (cs.length == 0) return false;
        boolean numAppeared = false;
        boolean eAppeared = false;
        boolean dotAppeared = false;
        int i = (cs[0] == '+'|| cs[0] == '-') ? 1:0;

        for (; i < cs.length; i++) {
            char c = cs[i];
            if (Character.isDigit(c)) {
                numAppeared = true;
            }else if (Character.toLowerCase(c) == 'e'){
                if (!numAppeared || eAppeared) return false;
                eAppeared = true;
                numAppeared = false;
            }else if (c == '+' || c== '-'){
                if (Character.toLowerCase(cs[i-1])!='e') return false;
            }else if (c == '.'){
                if (dotAppeared || eAppeared) return false;
                dotAppeared = true;
            }else {
                return false;
            }
        }
        return numAppeared;
    }
}

package Question.sword;

public class O67 {
    public static void main(String[] args) {
        O67 q = new O67();
        q.strToInt("-2147483648");
    }
    public int strToInt(String str) {
        if (str == null) return 0;

        str = str.trim();
        if (str.length() ==0) return 0;

        int left = 0;
        int right =0;

        while (left < str.length() && str.charAt(left) == ' ') {
            left++;
        }

        if (left >= str.length()){
            return 0;
        }

        right = (str.charAt(left) == '+' || str.charAt(left) == '-')? left+1:left;
        while (right < str.length() && Character.isDigit(str.charAt(right))){
            right++;
        }

        if (left >= right) return 0;

        boolean isNeg = str.charAt(left) == '-';
        char cs[] = str.substring(left,right).toCharArray();
        int res = 0;

        for (char c:cs) {
            int i = c - '0';
            if (c == '-' || c=='+'){
                isNeg = (c=='-');
                continue;
            }

            if (res > (Integer.MAX_VALUE-i)/10){
                if(isNeg) return Integer.MIN_VALUE;
                else return Integer.MAX_VALUE;
            }else if (isNeg && res > (Integer.MIN_VALUE +i)/(-10)){
                return Integer.MIN_VALUE;
            }

            res = res *10 + i;
        }
        return isNeg? -res:res;
    }
}

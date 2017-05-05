package Question.leetcode;

/**
 * Created by gump on 2017/5/5.
 */
public class Q13 {
    public int romanToInt(String s) {
        char input[] = s.toCharArray();
        int result = 0;

        for (int i = 0; i <input.length ; i++) {
            if(i<input.length-1 &&
                    toNumber(input[i])<toNumber(input[i+1])){

                result += (toNumber(input[i+1])-toNumber(input[i]));
                i++;
            }else{
                result += (toNumber(input[i]));
            }
        }
        return result;
    }

    int toNumber(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}

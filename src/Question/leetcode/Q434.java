package Question.leetcode;

/**
 * Created by gump on 2017/5/5.
 */
public class Q434 {
    public int countSegments(String s) {
        if (s.isEmpty()) return 0;
        char str[] = s.toCharArray();
        int result= 0;
        int i = 0;

        while (i<str.length){
            if(str[i] != ' '){
                result++;
                while (i<str.length && str[i] != ' '){
                    i++;
                }
            }else{
                i++;
            }
        }

        return result;
    }
}

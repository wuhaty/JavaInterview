package Question.leetcode;

/**
 * Created by gump on 2017/5/8.
 */
public class Q521 {
    public int findLUSlength(String a, String b) {
        if(a.length() ==b.length()){
            if (a.equals(b)) return -1;
            else return a.length();
        }else{
            return Math.max(a.length(),b.length());
        }
    }
}

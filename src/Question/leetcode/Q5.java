package Question.leetcode;

/**
 * Created by gump on 2017/5/6.
 */
public class Q5 {

    int maxLength = 0;
    int k = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            explore(s,i,i);
            explore(s,i,i+1);
        }
        return s.substring(k,k+maxLength);
    }

    public void explore(String s ,int i,int j){
        while (i>=0
                && j<s.length()
                && s.charAt(i) == s.charAt(j)){
            i--;j++;
        }

        if((j-i-1)>maxLength){
            maxLength=(j-i-1);
            k=i+1;
        }
    }
}

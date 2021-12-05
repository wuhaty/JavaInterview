package Question.leetcode.mock.m20211205;

public class LongestPalindrome {

    String max = "";

    public String longestPalindrome(String s) {
        if (s==null) return null;

        char[] cs = s.toCharArray();


        for (int i = 0; i < s.length()-1; i++) {
            find(cs,i,i);
            find(cs,i,i+1);
        }
        return max;
    }

    private void find(char[] cs, int l, int r) {
        if (l<0 || r>=cs.length) return;

        while (l<=r && l >= 0 && r<cs.length && cs[l] == cs[r]){
            l--;
            r++;
        }


        if (r-l-2 > max.length()) {
            max = new String(cs,l+1,r-l-2);
        }
    }
}

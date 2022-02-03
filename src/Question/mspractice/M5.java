package Question.mspractice;

public class M5 {

    int maxLength = 0;
    String res;
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            search(cs,i,i);
            if (i<cs.length-1) search(cs,i,i+1);
        }

        return res;
    }

    private void search(char[] cs, int l, int r) {
        if (r >= cs.length) return;

        while (l>=0 && r<cs.length && cs[l] == cs[r]){
            l--;
            r++;
        }

        int len = r - l +1;
        if (len > maxLength){
            maxLength = (r-l+1);
            res = String.valueOf(cs,l+1,len-1);
        }
    }
}
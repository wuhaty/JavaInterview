package Question.leetcode;

public class Q186 {

    public void reverseWords(char[] s) {
        reverse(s,0,s.length-1);

        int l=0,r = 0;

        while (r<s.length){
            if (r==s.length-1){
                reverse(s,l,r);
                break;
            }

            if (s[r] == ' '){
                reverse(s,l,r-1);
                l =r+1;
            }

            r++;
        }
    }

    public void reverse(char[] cs, int l, int r) {
        while (l<r){
            char c = cs[l];
            cs[l] = cs[r];
            cs[r] = c;
            l++;r--;
        }
    }
}

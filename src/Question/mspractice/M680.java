package Question.mspractice;

public class M680 {
    public boolean validPalindrome(String s) {
        if (s.length()<2) return false;

        int l = 0 , r = s.length() - 1;

        while (l<r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else {
                return palindrome(s,l+1,r) || palindrome(s,l,r-1);
            }
        }

        return true;
    }

    private boolean palindrome(String s, int l, int r) {
        while (l<r){
            if (s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else {
                return false;
            }
        }
        return true;
    }
}

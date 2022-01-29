package Question.mspractice;

public class M125 {
    public boolean isPalindrome(String s) {
        if (s == null) return false;

        char[] cs = s.toCharArray();

        int l = 0, r = cs.length -1;

        while (l<r){
            if (!Character.isLetterOrDigit(cs[l])) l++;
            else if (!Character.isLetterOrDigit(cs[r])) r--;
            else if (Character.toLowerCase(cs[l]) == Character.toLowerCase(cs[r])){
                l++; r--;
            }else {
                return false;
            }
        }
        return true;
    }
}

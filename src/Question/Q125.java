package Question;

/**
 * Created by gump on 2018/3/17.
 */
public class Q125 {
    public static void main(String argc[]){
        Q125 q = new Q125();
        System.out.println(q.isPalindrome("race a car"));
    }


    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        char str[] = s.toCharArray();
        int i=0,j=s.length()-1;

        while (i<j){
            if (!Character.isLetterOrDigit(str[i])) {
                i++;continue;
            }
            if (!Character.isLetterOrDigit(str[j])) {
                j--;continue;
            }

            if (str[i] != str[j]) return false;
            i++;j--;
        }
        return true;
    }

    public boolean isPalindrome2021(String s) {
        char[] cs = s.toLowerCase().toCharArray();
        int l=0,r=s.length()-1;

        while (l<r){
            if (!Character.isLetterOrDigit(cs[l])) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(cs[r])) {
                r--;
                continue;
            }

            if (cs[l] != cs[r]) return false;
            l++;r--;
        }
        return true;
    }
}

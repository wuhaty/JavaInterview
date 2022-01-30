package Question.mspractice.mock.d3;

public class q2 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() <= 1) return "";
        char[] cs = palindrome.toCharArray();

        int l = 0,half = palindrome.length()/2;
        while (l<= half){
            if (cs[l] != 'a'){
                cs[l] = 'a';
                return String.valueOf(cs);
            }
            l++;
        }

        cs[palindrome.length()-1] = 'b';

        return String.valueOf(cs);
    }

}

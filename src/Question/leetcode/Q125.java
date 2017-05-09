package Question.leetcode;

/**
 * Created by gump on 2017/5/8.
 */
public class Q125 {

    public static void main(String argc[]){
        Q125 q= new Q125();
        System.out.println(q.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        char input[] = s.toCharArray();
        int lo = 0;
        int hi = input.length - 1;

        while (lo < hi ) {
            while (lo<input.length && !judge(input[lo])){
                lo++;continue;
            }
            while (hi>=0 && !judge(input[hi])){
                hi--;continue;
            }

            if(lo>hi) return true;

            if(input[lo] == input[hi]
                    || (judge2(input[lo])
                        && judge(input[hi])
                        && Math.abs(input[lo]-input[hi])==('a'-'A'))){
                hi--;
                lo++;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean judge(char c) {
        return ('a'<=c && c<='z')
                || ('A'<=c && c<='Z')
                || ('0'<=c && c<='9');
    }

    public boolean judge2(char c) {
        return ('a'<=c && c<='z')
                || ('A'<=c && c<='Z');
    }
}

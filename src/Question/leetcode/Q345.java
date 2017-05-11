package Question.leetcode;

/**
 * Created by gump on 2017/5/9.
 */
public class Q345 {
    public String reverseVowels(String s) {
        if (s==null || s.isEmpty()) return s;
        char input[] = s.toCharArray();
        int lo = 0;
        int hi = input.length-1;
        while (lo<hi){
            while (lo<input.length && !check(input[lo])){
                lo++;
            }
            while (hi>=0 && !check(input[hi])){
                hi--;
            }

            if(lo>=hi) return new String(input);

            char temp = input[lo];
            input[lo] = input[hi];
            input[hi] = temp;
            lo--;
            hi++;
        }
        return new String(input);
    }

    public boolean check(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
                ||c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}

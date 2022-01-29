package Question.mspractice.mock.d2;

import java.util.*;

public class q3 {
    public static void main(String[] args) {
        q3 q = new q3();
        q.uniqueLetterString("LEETCODE");
    }

    public int uniqueLetterString(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int[] prev = new int[26];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(prev,-1);

        for (int i = 0; i < left.length; i++) {
            left[i] = prev[cs[i]-'A'];
            prev[cs[i]-'A'] = i;
        }

        Arrays.fill(prev,n);

        for (int i = n-1; i >=0 ; i--) {
            right[i] = prev[cs[i]-'A'];
            prev[cs[i]-'A'] = i;
        }
        //left[i]+1 ~ right[i]-1 is the range of cs[i] only occurs once
        //i-(left[i]+1)+1 = i-left[i]-1+1
        long res = 0;

        for (int i = 0; i < n; i++) {
            res+= (i-left[i])* (right[i]-i)% 1000000007;
        }
        return (int) (res % 1000000007);
    }

}

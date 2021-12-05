package Question.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1647 {

    public static void main(String[] args) {
        Q1647 q = new Q1647();
        q.minDeletionsSort("aaabbbcc");
    }

    public int minDeletions(String s) {
        int a[] = new int[26];
        char[] c = s.toCharArray();

        for (char ch:c) {
            a[ch-'a'] ++;
        }

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i:a) {
            if (i>0) {
                while (set.contains(i)){
                    i--;
                    count++;
                }

                if (i>0) {
                    set.add(i);
                }
            }
        }
        return count;
    }

    public int minDeletionsSort(String s){
        int a[] = new int[26];
        char[] c = s.toCharArray();

        for (char ch:c) {
            a[ch-'a'] ++;
        }

        Arrays.sort(a);
        int prev = a[25];
        int count = 0;
        for (int i = 24; i >=0 ; i--) {
            if (prev<=a[i]){
                prev = Math.max(0,prev-1);
                count += (a[i]-prev);
            }else {
                prev = a[i];
            }
        }

        return count;
    }

    public int minDeletions2021(String s) {
        char cs[] = s.toCharArray();
        int[] freq = new int[26];
        for (char c:cs) {
            freq[c-'a'] ++;
        }

        Set<Integer> freqs = new HashSet<>();
        int ans = 0;
        for (int f:freq) {
            if (f>0){
                while (freqs.contains(f)){
                    f--;
                    ans++;
                }

                if (f>0){
                    freqs.add(f);
                }
            }
        }
        return ans;
    }
}

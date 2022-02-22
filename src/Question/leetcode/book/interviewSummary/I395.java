package Question.leetcode.book.interviewSummary;

import java.util.Arrays;

public class I395 {
    public int longestSubstring(String s, int k) {
        int[] cnt = new int[26];
        int n = s.length();
        int ans = 0;
        char[] cs = s.toCharArray();

        for (int p = 1; p <= 26; p++) {
            Arrays.fill(cnt,0);

            for (int i = 0,j=0,tot=0,sum=0; i < n; i++) {
                int index = cs[i]-'a';
                cnt[index]++;
                if (cnt[index] == 1) tot++;
                if (cnt[index] == k) sum++;

                while (tot>p){
                    int leftIndex = cs[j++]-'a';
                    cnt[leftIndex]--;
                    if (cnt[leftIndex] ==0) tot--;
                    if (cnt[leftIndex] == k-1) sum--;
                }

                if (tot == sum) ans = Math.max(ans,i-j+1);
            }
        }
        
        return ans;
    }
}

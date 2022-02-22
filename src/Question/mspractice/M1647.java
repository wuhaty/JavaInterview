package Question.mspractice;

import java.util.*;

public class M1647 {
    public int minDeletions(String s) {
        int[] count = new int[26];

        for (char c:s.toCharArray()) {
            count[c-'a']++;
        }

        HashSet<Integer> freqSet = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            int freq = count[i];

            while (freq > 0){
                if (freqSet.contains(freq)){
                    ans++;
                    freq--;
                }else {
                    freqSet.add(freq);
                    break;
                }
            }
        }

        return ans;
    }
}

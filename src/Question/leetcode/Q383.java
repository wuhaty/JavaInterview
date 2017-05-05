package Question.leetcode;

import java.util.Arrays;

/**
 * Created by gump on 2017/5/5.
 */
public class Q383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.isEmpty()) return true;

        char ransom[] = ransomNote.toCharArray();
        char maga[] = magazine.toCharArray();

        Arrays.sort(ransom);
        Arrays.sort(maga);

        int j =0;
        for (int i = 0; i < maga.length ;i++) {
            if(ransom[j] == maga[i]){
                j++;
                if(j==ransom.length){
                    return true;
                }
            }
        }
        return false;
    }
}

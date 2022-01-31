package Question.mspractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class M953 {
    public static void main(String[] args) {
        M953 m = new M953();
        m.isAlienSorted(new String[]{"hello","leetcode"},"hlabcdefgijkmnopqrstuvwxyz");
    }

    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i),i);
        }

        for (int k = 1; k < words.length; k++) {
            char[] cs1 = words[k-1].toCharArray();
            char[] cs2 = words[k].toCharArray();

            int i = 0,j = 0;
            int n = cs1.length, m = cs2.length;
            boolean isSame = true;
            while (i < n && j < m) {
                int index1 = map.get(cs1[i]);
                int index2 = map.get(cs2[j]);
                if (index2 < index1) return false;
                if (index2 > index1) {
                    isSame = false;
                    break;
                }
                i++;j++;
            }

            if (isSame && m < n) return false;
        }

        return true;
    }
}

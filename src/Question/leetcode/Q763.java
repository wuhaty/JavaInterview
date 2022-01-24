package Question.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q763 {

    public static void main(String[] args) {
        Q763 q = new Q763();
        q.partitionLabels("ababcbacadefegdehijhklij");
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new LinkedList<>();

        Map<Character, Integer> lastOccur = new HashMap<>();

        char[] cs = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            lastOccur.put(cs[i],i);
        }

        int left = 0,right = 0;

        while (left < cs.length){
            char read = cs[left];
            int t = left;
            right = Math.max(right,lastOccur.get(read));
            while (t!=right){
                t++;
                right = Math.max(right,lastOccur.get(cs[t]));
            }
            res.add(right - left +1);
            left = right+1;
        }

        return res;
    }
}

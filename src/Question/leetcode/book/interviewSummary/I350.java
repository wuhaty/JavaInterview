package Question.leetcode.book.interviewSummary;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class I350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> l = new LinkedList<>();
        int p = 0,q=0;
        while (p<nums1.length && q<nums2.length){
            if (nums1[p] == nums2[q]) {
                l.add(nums1[p]);
                p++;q++;
            }else if (nums1[p]<nums2[q]){
                p++;
            }else {
                q++;
            }
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }
}

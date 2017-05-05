package Question.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by gump on 2017/5/3.
 */
public class Q349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> container = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;

        while (i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                container.add(nums1[i]);
                i++;
                j++;
            }else{
                if(nums1[i]<=nums2[j]){
                    i++;
                }else{
                    j++;
                }
            }
        }

        i=0;
        int result[] = new int[container.size()];
        for (Integer inte:container) {
            result[i++]=inte;
        }
        return result;
    }
}

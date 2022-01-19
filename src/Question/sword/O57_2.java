package Question.sword;

import java.util.*;

public class O57_2 {
    int sum = 0;
    List<int[]> res= new LinkedList<>();

    public static void main(String[] args) {
        O57_2 q = new O57_2();
        q.findContinuousSequence(9);
    }

    public int[][] findContinuousSequence(int target) {

        int l = 1;
        int r = 2;
        while (l<=(target/2) && l<r){
            int sum = (l + r) *(r-l+1)/2;

            if (sum == target && r-l>=1) {
                int[] nums = new int[r-l+1];
                for (int i = 0; i < (r-l+1); i++) {
                    nums[i] = l + i;
                }
                res.add(nums);
                l++;
            }else if (sum<target){
                r++;
            }else {
                l++;
            }
        }

        int[][] nums = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            int[] n = res.get(i);
            nums[i] = n;
        }

        return nums;
    }
}

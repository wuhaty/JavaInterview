package Question.sword;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class O61 {
    public static void main(String[] args) {
        O61 q = new O61();
        int nums[] = new int[]{1,2,3,4,5};
        q.isStraight(nums);
    }


    public boolean isStraightOri(int[] nums) {
        Arrays.sort(nums);
        int diff = 0;
        int pre = nums[0];
        int zeroCount = 0;
        Set<Integer> unique = new HashSet<>();
        if (pre ==0){
            zeroCount = 1;
        }else {
            unique.add(nums[0]);
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0){
                zeroCount++;
            }else {
                unique.add(nums[i]);
            }
            if (pre != 0){
                diff += (Math.abs(nums[i]-pre)-1);
            }
            pre = nums[i];
        }

        if (zeroCount >= diff && (unique.size()+zeroCount) == 5) return true;
        return false;
    }

    public boolean isStraight(int[] nums) {
        Set<Integer> s = new HashSet<>();
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MIN_VALUE;
        for (int i:nums) {
            if (i == 0) continue;
            if (s.contains(i)) return false;
            min = Math.min(min,i);
            max = Math.min(max,i);
            s.add(i);
        }
        return max-min<5;
    }
}

package Question.leetcode;

public class Q45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPos = 0;
        int step = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPos = Math.max(maxPos,i+nums[i]);

            //runt out of the last boundary
            if (i == end){
                step++;
                end = maxPos;
            }
        }
        return step;
    }
}

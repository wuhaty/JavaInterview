package Question.sword;

public class O42 {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int preMax = 0;
        for (int i:nums) {
            preMax = Math.max(preMax+i,i);
            max = Math.max(max,preMax);
        }
        return max;
    }
}

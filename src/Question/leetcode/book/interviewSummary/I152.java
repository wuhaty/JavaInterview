package Question.leetcode.book.interviewSummary;

public class I152 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mx = max;
            int mi = min;
            max = Math.max(mi*nums[i],Math.max(nums[i],mx*nums[i]));
            min = Math.min(mx*nums[i],Math.min(nums[i],mi*nums[i]));
            ans = Math.max(ans,max);
        }

        return ans;
    }
}

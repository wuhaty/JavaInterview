package Question.leetcode;

public class Q55 {

    public static void main(String[] args) {
        Q55 q = new Q55();
        System.out.println(q.canJumpDP(new int[]{0,2,3}));
    }

    public boolean canJump(int[] nums) {
        int rightMost = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost){
                rightMost = Math.max(rightMost,i+nums[i]);
                if (rightMost>=nums.length-1) return true;
            }
        }
        return false;
    }

    public boolean canJumpDP(int[] nums) {
        boolean dp[] = new boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + nums[j] >= i){
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length-1];
    }

}

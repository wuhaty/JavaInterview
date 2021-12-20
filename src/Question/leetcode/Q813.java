package Question.leetcode;

public class Q813 {
    public static void main(String[] args) {
        Q813 q = new Q813();
        int[] input = {9,1,2,3,9};
        q.largestSumOfAverages(input,3);
    }

    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[] preSum = new double[n+1];
        double[] dp = new double[n];

        for (int i = 0; i < n; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            dp[i] = (preSum[n]-preSum[i])/(n-i);
        }

        for (; k >1 ; k--) {
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    /**
                     * dp[i] = Math.max(dp[i],dp[j] + (preSum[j]-preSum[i])/(j-i));
                     * 其实直白意思就是不论你dp[j]的部分切的多么稀碎切的多么天花乱坠，
                     * 我就直接读上一轮的最大dp[j]+本轮即将被划分为新一组的(preSum[j]-preSum[i])/(j-i))算出总分 如果大即替换
                     */
                    dp[i] = Math.max(dp[i],dp[j] + (preSum[j]-preSum[i])/(j-i));
                }
            }
        }

        return dp[0];
    }
}

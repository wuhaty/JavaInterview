package Question.leetcode;

/**
 * Created by gump on 2017/5/7.
 */
public class Q312 {

    public static void main(String argc[]){
        Q312 q = new Q312();
        int test[]={3, 1, 5, 8};
        System.out.println(q.maxCoins(test));
    }

    private int maxCoins(int[] nums) {
        int input[] = new int[nums.length+2];
        int k = 0;
        for (; k < nums.length; k++) {
            input[k+1] = nums[k];
        }
        input[0]=input[k+1]= 1;

        int dp[][] = new int[input.length][input.length];

        for (int left = input.length-3; left >=0 ; left--) {
            for (int right = left+2; right <dp[0].length ; right++) {
                for (int l = left+1; l <right ; l++) {
                    dp[left][right] = Math.max(dp[left][right],
                            input[left]*input[l]*input[right]+dp[left][l]+dp[l][right]);
                }
            }
        }
        return dp[0][input.length-1];
    }


}

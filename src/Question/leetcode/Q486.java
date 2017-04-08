package Question.leetcode;

/**
 * Created by gump on 2017/4/8.
 */
public class Q486 {
    public boolean PredictTheWinner(int[] nums) {
        int f[][] = new int[nums.length][nums.length];
        int s[][] = new int[nums.length][nums.length];

        for(int i = nums.length-1;i>=0;i--){
            f[i][i] = nums[i];
            for(int j = i+1;j<nums.length;j++){
                f[i][j] = Math.max(nums[i]+s[i+1][j],nums[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return f[0][nums.length-1]>=s[0][nums.length-1];
    }

    public static void  main(String argc[]){

        Q486 q = new Q486();
        int data[] = {1,5,2};
        q.PredictTheWinner(data);
    }
}

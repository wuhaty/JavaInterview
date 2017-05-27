package Question.classified.DP;

/**
 * Created by gump on 2017/5/26.
 */
public class SubsetSum {
    public static void main(String argc[]){
        SubsetSum q = new SubsetSum();
        int data[] = {10,8,7,3,2};
        System.out.println(q.questionDFS(data,1));
    }

    public boolean questionDFS(int[] nums , int target){
        return dfs(nums,target,0);
    }

    public boolean dfs(int[] nums , int target , int i){
        if (target<0 || i>=nums.length) return false;
        if (target == 0) return true;

        if(dfs(nums,target-nums[i],i+1)
                || dfs(nums,target,i+1)){
            return true;
        }

        return false;
    }

    public boolean questionDP(int[] nums , int target){
        if (target<=0) return false;

        int n = nums.length;
        boolean dp[][] = new boolean[n+1][target+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < target+1; j++) {
                if (j<nums[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[n-1][target];
    }
}

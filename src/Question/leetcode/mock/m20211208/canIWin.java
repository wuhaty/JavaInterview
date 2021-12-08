package Question.leetcode.mock.m20211208;

public class canIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger>=desiredTotal) return true;
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;

        return dfs(0,desiredTotal,new Boolean[1<<maxChoosableInteger],maxChoosableInteger);
    }

    //Boolean array is used here to check unvisited case(null)
    private boolean dfs(int state, int desiredTotal, Boolean[] dp, int maxChoosableInteger) {
        if (dp[state] != null) return dp[state];

        for (int j = 1; j <= maxChoosableInteger; j++) {
            //j为当前要选择的数字
            //cur为当前要选数字在state中的位置
            int cur = 1<<(j-1);
            if((cur & state) != 0){
                //visited
                continue;
            }

            //选j直接赢 或者没法直接赢但是后手的人输了
            if (j>=desiredTotal || !dfs(cur|state,desiredTotal-j,dp,maxChoosableInteger)){
                return dp[state] = true;
            }
        }
        return dp[state] = false;
    }
}

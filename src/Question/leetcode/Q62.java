package Question.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2021/7/21.
 */
public class Q62 {


    Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Q62 q = new Q62();
        System.out.print(q.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {

        return dfs(0,0,m,n);
    }

    private int dfs(int x, int y, int m, int n) {
        if (x >= m || y>=n) return 0;
        if (x == m-1 && y == n-1) return 1;
        if (map.containsKey(x*n+y)) {
            return map.get(x*n+y);
        }

        int k =(dfs(x+1,y,m,n) + dfs(x,y+1,m,n));
        map.putIfAbsent(x*n+7,k);

        return k;

    }

    public int uniquePaths2021(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = i-1;
                int left = j-1;

                int upWay = (up < 0 )?0:dp[i-1][j];
                int leftWay = (left<0 )?0:dp[i][j-1];

                dp[i][j] = upWay+leftWay;
            }
        }

        return dp[m-1][n-1];
    }
}

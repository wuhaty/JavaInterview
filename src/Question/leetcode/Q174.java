package Question.leetcode;

/**
 * Created by gump on 2017/5/19.
 */
public class Q174 {
    public static void main(String argc[]){
        int dungen[][] ={
                {0,5},
                {-2,-3},
        };
        Q174 q= new Q174();
        q.calculateMinimumHP(dungen);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m][n];
        dp[m-1][n-1] = Math.max(1,1-dungeon[m-1][n-1]);

        for (int i = m-2; i >=0 ; i--) {
            dp[i][n-1] = Math.max(1,dp[i+1][n-1]-dungeon[i][n-1]);
        }

        for (int j = n-2; j >=0 ; j--) {
            dp[m-1][j] = Math.max(1,dp[m-1][j+1]-dungeon[m-1][j]);
        }

        for (int i = m-2; i >=0 ; i--) {
            for (int j = n-2; j >=0 ; j--) {
                int down = Math.max(1,dp[i+1][j]-dungeon[i][j]);
                int right = Math.max(1,dp[i][j+1]-dungeon[i][j]);
                dp[i][j] = Math.min(down,right);
            }
        }
        
        return dp[0][0];
    }


    public int calculateMinimumHPori(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;


        int i=0,j=0;
        int r=0,q=0;
        int maxDam = 0;
        int totalDam = 0;
        int orbs = 0;

        while (i<m && j<n){
            if(dungeon[i][j]>0){
                orbs += dungeon[i][j];
            }else{
                totalDam+=dungeon[i][j];

                if (dungeon[r][q]<0){
                    maxDam += dungeon[i][j];
                }else {
                    maxDam = Math.min(maxDam,dungeon[i][j]);
                }

                if (orbs>=Math.abs(maxDam)){
                    orbs +=maxDam;
                    maxDam=0;
                }
            }

            r=i;q=j;

            if(i==m-1){
                j++;
            }else if(j==n-1){
                i++;
            }else if(dungeon[i+1][j]>dungeon[i][j+1]){
                i++;
            }else{
                j++;
            }
        }

        return Math.max(Math.abs(maxDam)+1,Math.abs(totalDam)-orbs);
    }
}

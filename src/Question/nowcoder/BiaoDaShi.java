package Question.nowcoder;

/**
 * 对于一个只由0(假)、1(真)、&(逻辑与)、|(逻辑或)和^(异或)五种字符组成的逻辑表达式，再给定一个结果值。
 * 现在可以对这个没有括号的表达式任意加合法的括号，返回得到能有多少种加括号的方式，可以达到这个结果。
 * 给定一个字符串表达式exp及它的长度len，同时给定结果值ret,请返回方案数。
 * 保证表达式长度小于等于300。为了防止溢出，请返回答案Mod 10007的值。
 *
 * 测试样例：
 * "1^0|0|1",7,0
 * 返回：2
 */
public class BiaoDaShi {
    public static void main(String[] argc){
        System.out.print(countWays("1^0|0|1",7,0));
    }
    public static int countWays(String exp, int len, int ret) {
        char input[] = exp.toCharArray();
        char ops[] = new char[(input.length-1)/2];
        int digits[] = new int[(input.length+1)/2];

        int i = 0;
        while (i<input.length){
            if(i%2==0){
                digits[i/2] = input[i]-'0';
            }else {
                ops[i/2] = input[i];
            }
            i++;
        }
        return dp(digits,ops,ret)%10007;
    }

    private static int dp(int[] digits, char[] ops, int ret) {
        int n = digits.length;
        int dp[][][] = new int[n][n][2];

        for (int i = 0; i < n; i++) {
            if(digits[i] == 1){
                dp[i][i][1] = 1;
            }else {
                dp[i][i][0] = 1;
            }
        }

        for (int x = 1; x < n; x++) {
            for (int i = 0; i < n-x; i++) {
                int j = i+x;
                for (int k = i; k < j; k++) {
                    if(dp[i][k][0]!=0 && dp[k+1][j][0]!=0){
                        int num = cal(0,0,ops[k]);
                        dp[i][j][num] =(dp[i][j][num] + dp[i][k][0] * dp[k+1][j][0])% 10007;
                    }

                    if(dp[i][k][0]!=0 && dp[k+1][j][1]!=0){
                        int num = cal(0,1,ops[k]);
                        dp[i][j][num] =(dp[i][j][num] + dp[i][k][0] * dp[k+1][j][1])% 10007;
                    }

                    if(dp[i][k][1]!=0 && dp[k+1][j][0]!=0){
                        int num = cal(1,0,ops[k]);
                        dp[i][j][num] =(dp[i][j][num] + dp[i][k][1] * dp[k+1][j][0])% 10007;
                    }

                    if(dp[i][k][1]!=0 && dp[k+1][j][1]!=0){
                        int num = cal(1,1,ops[k]);
                        dp[i][j][num] =(dp[i][j][num] + dp[i][k][1] * dp[k+1][j][1])% 10007;
                    }
                }
            }
        }
        return dp[0][n-1][ret];
    }

    private static int cal(int i, int i1, char op) {
        switch (op){
            case '&':
                return i & i1;
            case '|':
                return i | i1;
            case '^':
                return i ^ i1;
        }
        return 0;
    }
}

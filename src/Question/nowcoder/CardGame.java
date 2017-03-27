package Question.nowcoder;

/**
 * 有一个整型数组A，代表数值不同的纸牌排成一条线。
 * 玩家a和玩家b依次拿走每张纸牌，规定玩家a先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，
 * 玩家a和玩家b都绝顶聪明，他们总会采用最优策略。请返回最后获胜者的分数。
 * 给定纸牌序列A及序列的大小n，请返回最后分数较高者得分数(相同则返回任意一个分数)。
 * 保证A中的元素均小于等于1000。且A的大小小于等于300。
 * 测试样例：
 *  [1,2,100,4],4
 * 返回：101
 */
public class CardGame {
    public static void main(String argc[]){
        System.out.print(cardGame(new int[]{1, 2, 100, 4},4));
    }

    public static int cardGame(int[] A, int n) {
        int f[][] = new int[A.length][A.length];
        int s[][] = new int[A.length][A.length];

        for (int j = 0; j < A.length; j++) {
            f[j][j] = A[j];
            for (int i = j-1; i>=0 ; i--) {
                f[i][j] = Math.max(A[i]+s[i+1][j],A[j]+s[i][j-1]);
                s[i][j] = Math.min(f[i+1][j],f[i][j-1]);
            }
        }
        return Math.max(f[0][A.length-1],s[0][A.length-1]);
    }
}

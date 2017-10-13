package Question.interview.wap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gump on 2017/9/24.
 */
public class Q1 {
    static int result = Integer.MAX_VALUE;
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            result = Integer.MAX_VALUE;
            int n  = sc.nextInt();
            int m  = sc.nextInt();
            boolean board[][] = new boolean[n][m];
            int sum = 0;
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                char input[] = sc.nextLine().toCharArray();
                for (int j = 0; j < input.length; j++) {
                    if (input[j]=='o'){
                        board[i][j] = true;
                        sum++;
                    }
                }
            }

            int k = sc.nextInt();

            dfs(board,k,sum,0,' ');
            System.out.println(result==Integer.MAX_VALUE?-1:result);
        }
    }

    private static void dfs(boolean[][] board, int k, int sum,int ops,char dir) {
        if (sum==k) {
            result = Math.min(ops,result);
            return;
        }

        boolean temp[][] = new boolean[board.length][board[0].length];

        int diff = 0;
        if (dir!='r'){
            //left
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (j==0 && board[i][j]) diff++;
                    temp[i][j] = j != board[0].length - 1 && board[i ][j+1];
                }
            }
            if (sum-diff>=k && diff!=0)
                dfs(temp,k,sum-diff,ops+1,'l');
            diff=0;
        }


        if (dir!='l'){
            //right
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (j== board[0].length-1 && board[i][j]) diff++;
                    temp[i][j] = j != 0 && board[i][j - 1];
                }
            }
            if (sum-diff>=k && diff!=0)
                dfs(temp,k,sum-diff,ops+1,'r');
            diff=0;
        }

        if (dir!='d'){
            //up
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (i== 0 && board[i][j]) diff++;
                    temp[i][j] = i != board.length-1 && board[i+1][j];
                }
            }
            if (sum-diff>=k&&diff!=0)
                dfs(temp,k,sum-diff,ops+1,'u');
            diff=0;
        }

        if(dir!='u'){
            //down
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (i== board.length-1 && board[i][j]) diff++;
                    temp[i][j] = i != 0  && board[i-1][j];
                }
            }
            if (sum-diff>=k&&diff!=0)
                dfs(temp,k,sum-diff,ops+1,'d');
        }

    }
}
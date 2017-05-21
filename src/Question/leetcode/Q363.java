package Question.leetcode;

import Question.classified.KadaneAlg;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by gump on 2017/5/18.
 */
public class Q363 {

    public static void main(String argc[]){
        Q363 q = new Q363();
//        int matrix[][] = {
//                {5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}
//        };
        int matrix[][] = {
                {-2,-3,11}
        };
        q.maxSumSubmatrix(matrix,8);
    }

    public int maxSumSubmatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;

        boolean colIsBig = col>row;
        int m = Math.min(row,col);
        int n = Math.max(row,col);
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            int array[] = new int[n];
            for (int j = i; j >=0 ; j--) {
                int val = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                for (int k = 0; k < n; k++) {
                    array[k] = array[k] + (colIsBig?matrix[j][k]:matrix[k][j]);
                    val = val + array[k];

                    Integer subRes = set.ceiling(val-target);

                    if(null!=subRes){
                        res = Math.max(res,val-subRes);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}

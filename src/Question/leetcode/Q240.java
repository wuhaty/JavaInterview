package Question.leetcode;

/**
 * Created by gump on 2021/7/2.
 */
public class Q240 {

    int target;

    public boolean searchMatrix(int[][] matrix, int tar) {
        if (matrix == null || matrix.length ==0) return false;
        target = tar;
        return search(matrix,0,matrix.length,0,matrix[0].length);
    }

    private boolean search(int[][] matrix, int u, int d, int l, int r) {
        if (u>d || l >r) return false;
        if (target < matrix[u][l] || target > matrix[d][r]) return false;

        int mid = l + (r-l)/2;


        int row = u;

        while (row <= d && matrix[row][mid] <=target) {
            if (matrix[row][mid] == target) return true;
            row ++;
        }

        return search(matrix,row,d,l,mid-1) || search(matrix,u,row-1,mid+1,r);
    }
}

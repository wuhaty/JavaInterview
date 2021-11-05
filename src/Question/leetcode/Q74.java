package Question.leetcode;

/**
 * Created by gump on 2021/7/11.
 */
public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r= matrix.length;
        int row = 0 ,col =0;
        while (l<=r) {
            int mid = (l+r)/2;

            if (matrix[mid][0] == target) return true;

            if (matrix[mid][0] > target) {
                r = mid -1;
            }else {
                row = mid;
                l = mid +1;
            }
        }

        l=0;r=matrix[0].length;
        while (l<=r) {
            int mid = (l+r)/2;

            if (matrix[row][mid] == target) return true;

            if (matrix[row][mid] > target) {
                r = mid -1;
            }else {
                l = mid +1;
            }
        }

        return false;
    }
}

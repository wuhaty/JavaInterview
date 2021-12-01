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

    public static void main(String[] args) {
        Q74 q = new Q74();
        int m[][] = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };
        q.searchMatrix2021(m,11);
    }

    public boolean searchMatrix2021(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        //binary search vertical
        int up = 0;
        int down = n-1;

        while (up<down){
            int mid = (up+down)/2;
            if (matrix[mid][0] == target) return true;
            if (target < matrix[mid][0]) {
                down = mid-1;
            }            else if (target < matrix[mid][0]) {
                down = mid-1;
            }else if (target > matrix[mid][m-1]){
                up = mid +1;
            }else{
                up = mid;
                break;
            }
        }

        //binary search horizontal
        int l = 0, r= m-1;
        while (l<=r){
            int mid = (l+r)/2;
            if (target == matrix[up][mid]) return true;
            else if (target<matrix[up][mid]){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }

        return false;
    }
}

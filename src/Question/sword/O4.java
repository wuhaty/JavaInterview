package Question.sword;

public class O4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (matrix[i].length == 0) continue;
            if (target< matrix[i][0]) return false;
            if (target > matrix[i][m-1]) continue;
            int l=0,r=m-1;
            while (l<=r){
                int mid = l + (r-l)/2;
                if (matrix[i][mid] == target) return true;
                if (matrix[i][mid]>target) {
                    r = mid-1;
                }else {
                    l = mid+1;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArrayBST(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int r = 0, c = matrix[0].length-1;

        while (r<n && c >= 0){
            if (matrix[r][c] == target) return true;
            if (matrix[r][c] < target) r ++;
            else c--;
        }
        return false;
    }
}

package Question.mspractice;

public class M240 {
    public boolean searchMatrixOpt(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0,j = n-1;

        while (i < m && j >= 0){
            if (matrix[i][j] == target) {
                return true;
            }else if (matrix[i][j] < target){
                i ++;
            }else {
                j--;
            }
        }

        return false;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int[] l:matrix) {
            int index = binarySearch(l,target);
            if (index>0) return true;
        }

        return false;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length -1;
        while (l<=r){
            int mid = (l+r)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target){
                r = mid -1;
            }else {
                l = mid +1;
            }
        }
        return -1;
    }
}
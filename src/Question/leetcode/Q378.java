package Question.leetcode;

import java.util.*;

public class Q378 {
    public int kthSmallestSort(int[][] matrix, int k) {
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                l.add(matrix[i][j]);
            }
        }
        Collections.sort(l);
        return l.get(k-1);
    }

    public int kthSmallestSortOptimized(int[][] matrix, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < matrix.length; i++) {
            q.offer(new int[]{matrix[i][0],i,0});
        }

        for (int i = 0; i < k-1; i++) {
            int[]r = q.poll();
            int row = r[1];
            int col = r[2];
            if (col < matrix[0].length){
                q.offer(new int[]{matrix[row][col+1]+1,row,col+1});
            }
        }

        return q.poll()[0];
    }

    public int kthSmallestBinarySearch(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = matrix[0][0], r = matrix[n-1][m-1];

        while (l<r){
            int mid = l + (r-l)/2;

            if (check(mid,matrix,k,n)){
                l = mid+1;
            }else {
                r = mid;
            }
        }

        return l;
    }

    private boolean check(int mid, int[][] matrix, int k, int n) {
        int i = n-1,j=0;
        int sum = 0;
        while (i>=0 && j<n){
            if (matrix[i][j]<=mid){
                sum+=(i+1);
                j++;
            }else {
                i--;
            }
        }

        return sum<k;
    }
}

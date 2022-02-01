package Question.mspractice.mock.d5;

import java.util.Deque;
import java.util.LinkedList;

public class q3 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null) return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[][] left = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    left[i][j] = ((j==0?0:left[i][j-1]) +1);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    int width = left[i][j];
                    int area = width;


                    for (int k = i-1; k >=0; k--) {
                        width = Math.min(width,left[k][j]);
                        area = Math.max(area,width*(i-k+1));
                    }
                    max = Math.max(max,area);
                }

            }
        }

        return max;
    }

    public int maximalRectangleStack(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] left = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    left[i][j] = (j==0? 0:left[i][j-1])+1;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            int l[] = new int[n];
            int r[] = new int[n];
            Deque<Integer> stack = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                l[i] = stack.isEmpty()? -1:stack.peek();
                stack.push(i);
            }

            stack.clear();

            for (int i = n-1; i >=0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]){
                    stack.pop();
                }
                r[i] = stack.isEmpty()? n:stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < n; i++) {
                max = Math.max(max, left[i][j] * (r[i] - l[i] -1));
            }
        }
        return max;
    }

    public int maximalRectangleOpt(char[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;
        int[] height = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1'){
                    height[j]++;
                }else {
                    height[j] = 0;
                }
            }
            max = Math.max(max,largestSquare(height));
        }

        return max;
    }

    private int largestSquare(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int p = 0, max = 0;

        while (p < height.length){
            if (stack.isEmpty()){
                stack.push(p);
                p++;
            }else {
                if (height[p] > height[stack.peek()]){
                    stack.push(p);
                    p++;
                }else {
                    int h = height[stack.pop()];
                    int left = stack.isEmpty()?-1:stack.peek();
                    int right = p;
                    max = Math.max(max,h*(right-left-1));
                }
            }
        }

        while (!stack.isEmpty()){
            int h = height[stack.pop()];
            int left = stack.isEmpty()?-1:stack.peek();
            int right = height.length;
            max = Math.max(max,h*(right-left-1));
        }

        return max;
    }

}

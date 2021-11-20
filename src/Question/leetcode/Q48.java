package Question.leetcode;

public class Q48 {

    public static void main(String[] args) {
        Q48 q = new Q48();

        int matrix[][] = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16},
        };

        q.rotate_2021(matrix);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int d = 0;
        int n = matrix.length;

        while (d < (n / 2)) {
            for (int i = 0; (i + d) < n - 1 - d; i++) {
                //i = d; j = d+i
                int a1 = matrix[d][d + i];
                int a2 = matrix[d + i][n - 1 - d];
                int a3 = matrix[n - 1 - d][n - 1 - d - i];
                int a4 = matrix[n - 1 - d - i][d];

                matrix[d][d + i] = a4;
                matrix[d + i][n - 1 - d] = a1;
                matrix[n - 1 - d][n - 1 - d - i] = a2;
                matrix[n - 1 - d - i][d] = a3;
            }

            d++;
        }
//        print(matrix);
    }

    public void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void rotate_2021(int[][] matrix) {
        int n = matrix.length;

        for (int k = 0; k < n; k++) {
            for (int j = k; j < n - k - 1; j++) {
                int t = matrix[k][j];
                matrix[k][j] = matrix[n - 1 -j][k];
                matrix[n - 1 -j][k] = matrix[n - 1 - k][n - 1 -j];
                matrix[n - 1 - k][n - 1 -j] = matrix[j][n - 1 - k];
                matrix[j][n - 1 - k] = t;
            }
        }
    }
}

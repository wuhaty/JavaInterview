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

        q.rotate(matrix);
    }

    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int d = 0;
        int n = matrix.length;

        while (d < (n / 2)) {
            for (int i = 0; (i +d)< n-1-d; i++) {
                //i = d; j = d+i
                int a1 = matrix[d][d + i];
                int a2 = matrix[d + i][n -1 - d];
                int a3 = matrix[n -1- d][n -1- d - i];
                int a4 = matrix[n -1- d - i][d];

                matrix[d][d + i] = a4;
                matrix[d + i][n-1 - d] = a1;
                matrix[n -1- d][n-1 - d - i] = a2;
                matrix[n -1 - d - i][d] = a3;
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
}

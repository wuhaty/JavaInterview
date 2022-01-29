package Question.mspractice;

import java.util.LinkedList;
import java.util.List;

public class M54 {

    public static void main(String[] args) {
        M54 q = new M54();
//        q.spiralOrder(new int[][]{
//                {1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}
//        });
        q.spiralOrder(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        });
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int n = matrix.length, m = matrix[0].length;

        int left = 0 , right = m -1, top = 0, bottom = n -1;
        int remain = n *m;

        while (remain > 0) {
            //top
            for (int j = left; j <= right && remain>0; j++) {
                res.add(matrix[top][j]);
                remain--;
            }

            top++;

            //right
            for (int i = top; i <=bottom && remain>0; i++) {
                res.add(matrix[i][right]);
                remain--;
            }

            right--;

            //bottom
            for (int j = right; j >=left && remain>0; j--) {
                res.add(matrix[bottom][j]);
                remain--;
            }

            bottom--;

            //left
            for (int i = bottom; i>=top && remain>0; i--) {
                res.add(matrix[i][left]);
                remain--;
            }
            left++;
        }
        return res;
    }
}

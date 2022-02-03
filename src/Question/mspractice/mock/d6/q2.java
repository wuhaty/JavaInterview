package Question.mspractice.mock.d6;

import java.util.*;

public class q2 {
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.putIfAbsent(i-j,new PriorityQueue<>());
                map.get(i-j).offer(mat[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = map.get(i-j).poll();
            }
        }

        return mat;
    }

}

package Question.leetcode.weeklyContest;

import java.util.Arrays;

public class W174Q1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int res[] = new int[k];
        Arrays.fill(res,-1);
        int q = 0;
        for (int j = 0; j < mat[0].length; j++) {
            if (q == k) break;
            for (int i = 0; i < mat.length && q<k; i++) {
                if (contains(res,i)) continue;
                if (mat[i][j] == 0){
                    res[q] = i;
                    q++;
                }
            }
        }

        for (int i = 0; i < mat.length && q<k; i++) {
            if (!contains(res,i)) {
                res[q] = i;
                q++;
            }
        }

        return res;
    }

    public boolean contains(int a[], int key){
        return Arrays.stream(a).anyMatch(i -> i==key);
    }
}
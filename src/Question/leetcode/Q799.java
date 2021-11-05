package Question.leetcode;


import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2018/3/16.
 */
public class Q799 {

    public static void main(String args[]) {
        Q799 q = new Q799();
        System.out.println(q.champagneTower(4, 1, 1));
    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double dp[][] = new double[100][100];
        dp[0][0] = poured;

        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) dp[i][j] = Math.max((dp[i - 1][j - 1] - 1) / 2, 0);
                if (j < i) dp[i][j] += Math.max((dp[i - 1][j] - 1) / 2, 0);
            }
        }

        return Math.min(1, dp[query_row][query_glass]);
    }


    public double champagneTowerOri(int poured, int query_row, int query_glass) {
        Map<AbstractMap.SimpleEntry<Integer, Integer>, Double> m = new HashMap<>();
        m.putIfAbsent(new AbstractMap.SimpleEntry<>(0, 0), (double) poured);
        double res = helper(m, poured, query_row, query_glass);
        return Math.min(res, 1);
    }

    private double helper(Map<AbstractMap.SimpleEntry<Integer, Integer>, Double> m, int poured, int query_row, int query_glass) {
        if (m.containsKey(new AbstractMap.SimpleEntry<>(query_row, query_glass))) {
            return m.get(new AbstractMap.SimpleEntry<>(query_row, query_glass));
        }

        if (query_row == 0) return poured;

        double left = 0;
        double right = 0;

        if (query_glass != 0) left = Math.max(0.5 * (helper(m, poured, query_row - 1, query_glass - 1) - 1), 0);
        if (query_glass != query_row) right = Math.max(0.5 * (helper(m, poured, query_row - 1, query_glass) - 1), 0);

        m.putIfAbsent(new AbstractMap.SimpleEntry<>(query_row, query_glass), left + right);

        return right + left;
    }
}

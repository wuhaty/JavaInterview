package Question.leetcode;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2021/7/21.
 */
public class Q62 {


    Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Q62 q = new Q62();
        System.out.print(q.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {

        return dfs(0,0,m,n);
    }

    private int dfs(int x, int y, int m, int n) {
        if (x >= m || y>=n) return 0;
        if (x == m-1 && y == n-1) return 1;
        if (map.containsKey(x*n+y)) {
            return map.get(x*n+y);
        }

        int k =(dfs(x+1,y,m,n) + dfs(x,y+1,m,n));
        map.putIfAbsent(x*n+7,k);

        return k;

    }
}

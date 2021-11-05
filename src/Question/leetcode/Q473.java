package Question.leetcode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by gump on 2021/8/25.
 */
public class Q473 {
    int perimeter = 0;
    int sum[] = new int[4];

    public boolean makesquare(int[] matchsticks) {

        for (int i = 0; i < matchsticks.length; i++) {
            perimeter +=matchsticks[i];
        }

        if (perimeter %4 != 0) return false;

        return dfs(0,matchsticks);
    }

    private boolean dfs(int index, int[] matchsticks) {
        if (index == matchsticks.length) {
            return sum[0] == sum[1] && sum[1] == sum[2] && sum[2] == sum[3];
        }


        for (int i = 0; i < 4; i++) {

            if ((sum[i]+matchsticks[index]) > (perimeter/4)){
                continue;
            }

            sum[i] += matchsticks[index];


            if (dfs(index+1 ,matchsticks)) {
                return true;
            }
            sum[i] -= matchsticks[index];
        }

        return false;
    }
}

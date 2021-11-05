package Question.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/6/8.
 */
public class Q54 {

    int order[][] = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };

    HashSet<Integer> visited = new HashSet<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();

        int n = matrix.length;
        int m = matrix[0].length;
        int total = n*m;
        int curOrder = 0;
        int x = 0;
        int y = 0;

        while (true) {
            Integer index = (x*m) + y;
            visited.add(index);
            result.add(matrix[x][y]);

            if (result.size() == total) return result;

            x += order[curOrder][0];
            y += order[curOrder][1];

            if (visited.contains((x*m) + y) || x<0 || y<0 || x>=n || y>=m) {
                x -= order[curOrder][0];
                y -= order[curOrder][1];
                curOrder = nextOrder(curOrder);
                x += order[curOrder][0];
                y += order[curOrder][1];
            }
        }

    }


    public int nextOrder(int index) {
        return (index+1)% 4;
    }
}

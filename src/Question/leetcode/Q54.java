package Question.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2021/6/8.
 */
public class Q54 {

    int order[][] = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    HashSet<Integer> visited = new HashSet<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();

        int n = matrix.length;
        int m = matrix[0].length;
        int total = n * m;
        int curOrder = 0;
        int x = 0;
        int y = 0;

        while (true) {
            Integer index = (x * m) + y;
            visited.add(index);
            result.add(matrix[x][y]);

            if (result.size() == total) return result;

            x += order[curOrder][0];
            y += order[curOrder][1];

            if (visited.contains((x * m) + y) || x < 0 || y < 0 || x >= n || y >= m) {
                x -= order[curOrder][0];
                y -= order[curOrder][1];
                curOrder = nextOrder(curOrder);
                x += order[curOrder][0];
                y += order[curOrder][1];
            }
        }

    }

    public int nextOrder(int index) {
        return (index + 1) % 4;
    }

    public List<Integer> spiralOrder2021(int[][] matrix) {
        List<Integer> res = new LinkedList<>();
        int x = 0;
        int y = 0;
        int dir = 0;
        int width = matrix[0].length;
        int height = matrix.length;


        while (visited.size() < (width * height)) {
            int index = (x * width + y);

            if (!visited.contains(index)) {
                res.add(matrix[x][y]);
                visited.add(index);
            }

            int tx = x+order[dir][0];
            int ty = y+order[dir][1];
            int tIndex = (tx * width + ty);
            int count = 0;
            while (count < 4 && (visited.contains(tIndex) || tx<0 || tx >= height || ty >= width || ty <0)){
                dir = nextOrder(dir);
                tx = x+order[dir][0];
                ty = y+order[dir][1];
                tIndex = (tx * width + ty);
                count++;
            }
            x = tx;
            y = ty;
        }

        return res;
    }


    public static void main(String[] args) {
        Q54 q = new Q54();
        int[][] input = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        q.spiralOrder2021(input);
    }
}

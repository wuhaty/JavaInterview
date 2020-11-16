package Question.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by gump on 2018/3/16.
 */
public class Q797 {

    public static void main(String args[]){
        int[][] temp = {{1,2}, {3}, {3}, {}};
        Q797 q = new Q797();
        q.allPathsSourceTarget(temp);
    }


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap();
        int m = graph.length;

        for (int i = 0; i < m; i++) {
            List<Integer> temp = new LinkedList<>();
            map.put(i, temp);
            for (int j = 0; j < graph[i].length; j++) {
                temp.add(graph[i][j]);
            }
        }

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        path.add(0);
        helper(map, 0, m - 1, path, result);
        return result;
    }

    private void helper(Map<Integer, List<Integer>> map, int start, int end, List<Integer> path, List<List<Integer>> result) {
        if (start == end) {
            List<Integer> temp = new LinkedList<>();
            temp.addAll(path);
            result.add(temp);
            return;
        }

        for (int next:map.get(start)) {
            path.add(next);
            helper(map,next,end,path,result);
            path.remove(new Integer(next));
        }
    }
}

package Question.leetcode.weeklyContest;

import java.util.*;

/**
 * Created by gump on 2017/9/24.
 */

// TODO: 2017/9/29 use bfs to do the loop search
public class W51Q684 {

    public static void main(String argc[]) {
        W51Q684 q = new W51Q684();
        int input[][] = new int[3][2];
        input[0] = new int[]{1, 2};
        input[1] = new int[]{1, 3};
        input[2] = new int[]{2, 3};
        System.out.println(Arrays.toString(q.findRedundantConnection(input)));
    }


    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, ArrayList<Integer>> adjlist = new LinkedHashMap<>();
        Set<Integer> counter = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            counter.add(edges[i][0]);
            counter.add(edges[i][1]);
            adjlist.putIfAbsent(edges[i][0], new ArrayList<>());
            adjlist.putIfAbsent(edges[i][1], new ArrayList<>());

            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);

            Map<Integer, Integer> visited = new HashMap<>();
            boolean result = true;

            for (int j = 0; j <= i; j++) {
                result = result && dfs(edges[j][0], adjlist, visited);
                if (!result) {
                    int r[] = {edges[i][0], edges[i][1]};
                    return r;
                }
            }
        }
        return null;
    }

    private boolean dfs(int from, Map<Integer, ArrayList<Integer>> adjlist, Map<Integer, Integer> visited) {
        if (visited.containsKey(from) && visited.get(from) == 0) {
            return false;
        }

        visited.put(from, 0);
        for (Integer dest : adjlist.get(from)) {
            if (!dfs(dest, adjlist, visited)) {
                    return false;
            }
        }
        visited.put(from, 1);
        return true;
    }
}

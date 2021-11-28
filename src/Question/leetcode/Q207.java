package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/4/20.
 */
public class Q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];
        for (int rel[]:prerequisites) {
            int from = rel[0];
            int to = rel[1];

            indegree[to]++;
            matrix[from][to] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int count = 0;

        while (!queue.isEmpty()){
            int start = queue.poll();
            count ++;

            for (int i = 0; i < matrix.length; i++) {
                if(matrix[start][i]==1){
                    if(--indegree[i]==0)queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }

    public boolean canFinish2021(int numCourses, int[][] prerequisites) {
        int[][] m = new int[numCourses][numCourses];

        for (int[] p:prerequisites) {
            m[p[0]][p[1]] = 1;
        }

        int visited[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(m,visited,i,numCourses)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] m, int[] visited, int i,int n ) {
        if (visited[i]==1) return true;
        if (visited[i] == -1) return false;
        visited[i] = 1;
        for (int j = 0; j < n; j++) {
            if (m[i][j]==1) {
                boolean res = dfs(m,visited,j,n);
                if (res) return true;
            }
        }
        visited[i] = -1;

        return false;
    }

    public boolean canFinish2021Queue(int numCourses, int[][] prerequisites){
        int[] indegree = new int[numCourses];
        Map<Integer,LinkedList<Integer>> m = new HashMap<>();

        for (int[] pre:prerequisites) {
            m.putIfAbsent(pre[1],new LinkedList<>());
            m.get(pre[1]).add(pre[0]);
            indegree[pre[0]] ++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int visited = 0;

        while (!q.isEmpty()){
            visited++;
            int c = q.poll();
            for (Integer d:m.getOrDefault(c,new LinkedList<>())) {
                indegree[d] --;
                if (indegree[d] == 0) {
                    q.offer(d);
                }
            }
        }

        return visited == numCourses;
    }

    public static void main(String argc[]){
        Q207 q =new Q207();
//        int d[][]={{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
//        int d[][]={{1,0},{0,1}};
        int d[][]={{1,0}};
//        int d[][]={{1,4},{2,4},{3,1},{3,2}};
        System.out.println(q.canFinish2021Queue(2,d));
    }
}

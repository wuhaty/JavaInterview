package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/4/21.
 */
public class Q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>(numCourses);
        int degree[] = new int[numCourses];


        int n = degree.length;

        while (n-- >0) adjs.add(new ArrayList<>());

        for (int e[]:prerequisites) {
            adjs.get(e[1]).add(e[0]);
            degree[e[0]]++;
        }

        Queue<Integer> q = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if(degree[i]==0) q.offer(i);
        }

        int result[] = new int[numCourses];
        int i =0;
        while (!q.isEmpty()){
            int temp = q.poll();
            result[i++] = temp;
            for (Integer from:adjs.get(temp)){
                degree[from] --;
                if(degree[from]==0)q.offer(from);
            }
        }
        return i==numCourses?result: new int[0];
    }

    public int[] findOrder2021(int numCourses, int[][] prerequisites) {
        int m[][] = new int[numCourses][numCourses];
        int indegree[] = new int[numCourses];
        int[] res = new int[numCourses];
        for (int[] edge:prerequisites) {
            int from = edge[1];
            int to = edge[0];
            m[from][to] =1;
            indegree[to] ++;
        }

        Queue<Integer> s = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                s.offer(i);
            }
        }

        int count = 0;
        while (!s.isEmpty()){
            Integer from = s.poll();
            res[count] = from;
            int[] edges = m[from];
            for (int i = 0; i < edges.length; i++) {
                int to = i;
                if (m[from][to] == 1) {
                    indegree[to] --;
                    if (indegree[to] == 0) {
                        s.offer(to);
                    }
                }
            }
            count++;
        }
        return count==numCourses?res:new int[0];
    }

    public static void main(String argc[]){
        Q210 q =new Q210();
//        int d[][]={{1,0}};
        int d[][]={{1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(q.findOrder2021(4, d)));
    }
}

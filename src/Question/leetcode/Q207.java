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

    public static void main(String argc[]){
        Q207 q =new Q207();
        int d[][]={{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
        System.out.println(q.canFinish(8,d));
    }
}

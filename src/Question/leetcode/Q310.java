package Question.leetcode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * Created by gump on 2017/4/19.
 */
public class Q310 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,ArrayList<Integer>> e = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            e.putIfAbsent(from,new ArrayList<>());
            e.putIfAbsent(to,new ArrayList<>());
            e.get(from).add(to);
            e.get(to).add(from);
        }


        ArrayList<Integer> leaves = new ArrayList<>();
        for (Integer i:e.keySet()) {
            if(e.get(i).size()==1){
                leaves.add(i);
            }
        }



        while(n>2) {
            n-=leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();

            for (Integer leaf:leaves) {
                int j = e.get(leaf).iterator().next();
                e.get(j).remove(leaf);
                if(e.get(j).size()==1){
                    newLeaves.add(j) ;
                }
            }
            leaves = newLeaves;
        }

        return leaves;
    }

    public static void main(String argc[]){
        int test[][] ={{0,1},{0,2},{0,3},{3,4},{4,5}};

        System.out.println(findMinHeightTrees(6,test));
    }
}

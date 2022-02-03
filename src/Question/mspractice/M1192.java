package Question.mspractice;

import java.util.*;

public class M1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Set<Integer>> m = new HashMap<>();
        buildMap(connections,m);
        int[] idBook = new int[n];
        Arrays.fill(idBook,-1);
        dfs(0,0,-1,m,idBook,res);

        return res;
    }

    private int dfs(int index, int id, int parent, Map<Integer, Set<Integer>> m, int[] idBook, List<List<Integer>> res) {
        idBook[index] = id;

        for (Integer neighbor:m.get(index)) {
            if (neighbor == parent) continue;
            else if (idBook[neighbor] == -1){
                idBook[index] = Math.min(idBook[index],dfs(neighbor,id+1,index,m,idBook,res));
            }else {
                idBook[index] = Math.min(idBook[index],idBook[neighbor]);
            }
        }

        if (idBook[index] == id && id != 0){
            res.add(Arrays.asList(index,parent));
        }
        return idBook[index];
    }

    private void buildMap(List<List<Integer>> connections, Map<Integer, Set<Integer>> m) {
        for (List<Integer> edge:connections) {
            int n1 = edge.get(0);
            int n2 = edge.get(1);

            m.putIfAbsent(n1,new HashSet<>());
            m.putIfAbsent(n2,new HashSet<>());
            m.get(n1).add(n2);
            m.get(n2).add(n1);
        }
    }
}

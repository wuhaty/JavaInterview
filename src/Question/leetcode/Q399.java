package Question.leetcode;



import javafx.util.Pair;

import java.util.*;

/**
 * Created by gump on 2017/4/17.
 */
public class Q399 {

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        Map<String,LinkedList<Pair<String,String>>> V = new HashMap<>();
        Map<Pair<String,String>,Double> E = new HashMap<>();

        int i =0;
        for (String pair[]:equations) {
            Pair<String,String> edge0 = new Pair<>(pair[0],pair[1]);
            E.put(edge0,values[i]);
            if(V.containsKey(pair[0])){
                V.get(pair[0]).add(edge0);
            }else{
                LinkedList<Pair<String,String>> list = new LinkedList<>();
                list.add(edge0);
                V.put(pair[0],list);
            }

            Pair<String,String> edge1 = new Pair<>(pair[1],pair[0]);
            E.put(edge1,1/values[i]);
            if(V.containsKey(pair[1])){
                V.get(pair[1]).add(edge1);
            }else{
                LinkedList<Pair<String,String>> list = new LinkedList<>();
                list.add(edge1);
                V.put(pair[1],list);
            }
            i++;
        }



        int j =0;
        double result[] = new double[queries.length];
        for (String pair[]:queries) {
            if(!V.containsKey(pair[0])
                    || !V.containsKey(pair[1])){
                result[j] = -1;
            }else{
                Map<Pair<String,String>,Boolean> visited = new HashMap<>();
                result[j] = dfs(V,E,visited,new Pair<>(pair[0],pair[1]));
                if(result[j]==0) result[j] = -1;
            }
            j++;
        }
        return result;
    }

    private static double dfs(Map<String, LinkedList<Pair<String, String>>> v, Map<Pair<String, String>, Double> e,
                              Map<Pair<String, String>, Boolean> visited, Pair<String, String> target) {
        if(target.getKey().equals(target.getValue())) return 1;
        if(visited.get(new Pair<>(target.getValue(),target.getKey()))!=null){
            return 0;
        }

        LinkedList<Pair<String, String>> edges = v.get(target.getKey());
        double subQuery=0;
        for (Pair<String, String> edge:edges) {
            if(visited.get(new Pair<>(edge.getValue(),edge.getKey()))!=null){
                continue;
            }
            if(visited.get(edge)==null){
                visited.put(edge,true);
                double result = e.get(edge);
                if(edge.equals(target)){
                    return result;
                }else{
                    subQuery = result*dfs(v,e,visited,new Pair<>(edge.getValue(),target.getValue()));
                    if(subQuery !=0.0){
                        break;
                    }
                }
            }
        }
        return subQuery;
    }

    public static void main (String argc[]){
        String a[][] = {{"a","e"},{"b","e"}};
        double v[] = {4,3 };
        String query[][] = {{"a","b"},{"e","e"},{"x","x"}};

        System.out.println(calcEquation(a,v,query));
    }
}

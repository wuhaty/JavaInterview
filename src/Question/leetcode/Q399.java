package Question.leetcode;




import java.util.*;

/**
 * Created by gump on 2017/4/17.
 */
public class Q399 {

    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        Map<String,LinkedList<AbstractMap.SimpleEntry<String,String>>> V = new HashMap<>();
        Map<AbstractMap.SimpleEntry<String,String>,Double> E = new HashMap<>();

        int i =0;
        for (String pair[]:equations) {
            AbstractMap.SimpleEntry<String,String> edge0 = new AbstractMap.SimpleEntry<>(pair[0],pair[1]);
            E.put(edge0,values[i]);
            if(V.containsKey(pair[0])){
                V.get(pair[0]).add(edge0);
            }else{
                LinkedList<AbstractMap.SimpleEntry<String,String>> list = new LinkedList<>();
                list.add(edge0);
                V.put(pair[0],list);
            }

            AbstractMap.SimpleEntry<String,String> edge1 = new AbstractMap.SimpleEntry<>(pair[1],pair[0]);
            E.put(edge1,1/values[i]);
            if(V.containsKey(pair[1])){
                V.get(pair[1]).add(edge1);
            }else{
                LinkedList<AbstractMap.SimpleEntry<String,String>> list = new LinkedList<>();
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
                Map<AbstractMap.SimpleEntry<String,String>,Boolean> visited = new HashMap<>();
                result[j] = dfs(V,E,visited,new AbstractMap.SimpleEntry<>(pair[0],pair[1]));
                if(result[j]==0) result[j] = -1;
            }
            j++;
        }
        return result;
    }

    private static double dfs(Map<String, LinkedList<AbstractMap.SimpleEntry<String, String>>> v, Map<AbstractMap.SimpleEntry<String, String>, Double> e,
                              Map<AbstractMap.SimpleEntry<String, String>, Boolean> visited, AbstractMap.SimpleEntry<String, String> target) {
        if(target.getKey().equals(target.getValue())) return 1;
        if(visited.get(new AbstractMap.SimpleEntry<>(target.getValue(),target.getKey()))!=null){
            return 0;
        }

        LinkedList<AbstractMap.SimpleEntry<String, String>> edges = v.get(target.getKey());
        double subQuery=0;
        for (AbstractMap.SimpleEntry<String, String> edge:edges) {
            if(visited.get(new AbstractMap.SimpleEntry<>(edge.getValue(),edge.getKey()))!=null){
                continue;
            }
            if(visited.get(edge)==null){
                visited.put(edge,true);
                double result = e.get(edge);
                if(edge.equals(target)){
                    return result;
                }else{
                    subQuery = result*dfs(v,e,visited,new AbstractMap.SimpleEntry<>(edge.getValue(),target.getValue()));
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

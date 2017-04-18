package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/4/18.
 */
public class Q332Recusive {
    public static List<String> findItinerary(String[][] tickets) {
        Map<String ,PriorityQueue<String>> e = new HashMap<>();
        for (String s[]:tickets) {
            String from = s[0];
            String to = s[1];
            if(!e.containsKey(from)){
                e.put(from,new PriorityQueue<>());
            }
            e.get(from).add(to);
        }

        ArrayList<String> result = new ArrayList<>();
        dfs(e,result,"JFK");
        return result;
    }

    private static void dfs(Map<String, PriorityQueue<String>> e, ArrayList<String> result, String start) {
        while (e.containsKey(start) && !e.get(start).isEmpty()){
            dfs(e,result,e.get(start).poll());
        }
        result.add(0,start);
    }


    public static void main(String argc[]){
        String tickets[][]= {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        System.out.println(findItinerary(tickets));
    }
}
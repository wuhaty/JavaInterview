package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/4/18.
 */
public class Q332Iterative {


    public static void main(String argc[]){
        String tickets[][]= {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        System.out.println(findItinerary(tickets));
        Stack<String> s = new Stack<>();

    }

    public static List<String> findItinerary(String[][] tickets) {
        Map<String ,PriorityQueue<String>> e = new HashMap<>();
        for (String s[]:tickets)
            e.computeIfAbsent(s[0], k -> new PriorityQueue()).add(s[1]);

        List<String> result = new ArrayList<>();

        Stack<String> stack= new Stack<>();
        stack.push("JFK");

        while (!stack.isEmpty()){
            while (e.get(stack.peek())!=null && !e.get(stack.peek()).isEmpty()){
                stack.push(e.get(stack.peek()).poll());
            }
            result.add(0,stack.pop());
        }
        return result;
    }
}

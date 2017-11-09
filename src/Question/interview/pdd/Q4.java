package Question.interview.pdd;
import java.util.*;

/**
 * Created by gump on 2017/11/9.
 */
public class Q4 {
    public static void q4(LinkedList<LinkedList<Integer>> a,int k){
        LinkedList<Integer> l = new LinkedList<>();

        for (LinkedList<Integer> arr:a) {
            l.addAll(arr);
        }

        Collections.sort(l);

        Set<Integer> result = new TreeSet<>();
        int score = 0;
        for (int i = 0; i < l.size(); i++) {
            Set<Integer> visited = new TreeSet<>();
            for (int j = i; j < l.size(); j++) {
                int temp = l.get(j);
                for (LinkedList<Integer> arr:a) {
                    if(!visited.contains(temp) && arr.contains(temp)){
                        visited.add(temp);
                        score++;
                    }
                }
                if (score==k){
                    if (result.isEmpty() || result.iterator().next() <visited.iterator().next()){
                        result = visited;
                    }
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
    }
}

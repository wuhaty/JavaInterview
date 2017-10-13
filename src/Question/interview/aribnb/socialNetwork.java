package Question.interview.aribnb;

import java.util.*;

/**
 * Created by gump on 2017/9/28.
 */
public class socialNetwork {

    public static void main(String argc[]) {
        socialNetwork q = new socialNetwork();
        int input[] = {2, 2, 2, 2};
        q.socialGraphs(input);
    }


    public static void socialGraphs(int[] counts) {
        int n = counts.length;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list;
            if (!map.containsKey(counts[i])) {
                list = new ArrayList<>();
                lists.add(list);
                map.put(counts[i], list);
            }
            list = map.get(counts[i]);
            list.add(i);
            if (list.size() == counts[i]) {
                map.remove(counts[i]);
            }

        }
        for (List<Integer> value : lists) {
            for (Integer num : value)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}

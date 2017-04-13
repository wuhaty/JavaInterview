package Question.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gump on 2017/4/12.
 */
public class Q120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer result[] = new Integer[triangle.size()];
        result = triangle.get(triangle.size()-1).toArray(result);

        for (int i = triangle.size()-2; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                result[j] = Math.min(result[j],result[j+1]) + triangle.get(i).get(j);
            }
        }
        return result[0];
    }

    public static void main(String argc[]){
        List<List<Integer>> test= new ArrayList();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        List<Integer> list3 = new ArrayList<>();
        list3.add(4);
        list3.add(5);
        list3.add(6);
        List<Integer> list4 = new ArrayList<>();
        list4.add(7);
        list4.add(8);
        list4.add(9);
        list4.add(10);

        test.add(list1);
        test.add(list2);
        test.add(list3);
        test.add(list4);
        System.out.println(minimumTotal(test));
    }
}

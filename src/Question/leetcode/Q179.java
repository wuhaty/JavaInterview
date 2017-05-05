package Question.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gump on 2017/5/2.
 */
public class Q179 {

    public static void main(String argc[]){
        Q179 q = new Q179();
        int test[] = {3, 30, 34, 5, 9};
        System.out.println(q.largestNumber(test));
    }

    public String largestNumber(int[] nums) {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            data.add(String.valueOf(nums[i]));
        }

        Collections.sort(data, (a,b)-> -(a+b).compareTo(b+a));
        StringBuilder sb = new StringBuilder();
        for (String i:data) {
            sb.append(i);
        }
        return sb.charAt(0)=='0'?"0":sb.toString();
    }
}

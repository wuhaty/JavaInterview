package Question.sword;

import java.util.HashSet;
import java.util.Set;

public class O56_2 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n:nums) {
                if (((n>>i)&1) == 1){
                    count++;
                }
            }

            if (count % 3 ==1) {
                res |= 1<<i;
            }
        }

        return res;
    }

    public int singleNumberSum(int[] nums) {
        long uniqueSum = 0;
        long sum = 0;

        Set<Integer> s = new HashSet<>();
        for (int i:nums) {
            sum+=i;
            s.add(i);
        }

        for (int i:s) {
            uniqueSum+=i;
        }
        return (int) ((uniqueSum*3-sum)/2);
    }

}

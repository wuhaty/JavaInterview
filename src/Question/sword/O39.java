package Question.sword;

public class O39 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer pre = null;
        for (int i:nums) {
            if (count ==0) pre = i;
            count += (pre==i?1:-1);
        }

        return pre;
    }
}

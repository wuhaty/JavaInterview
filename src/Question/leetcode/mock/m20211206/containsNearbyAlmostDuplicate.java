package Question.leetcode.mock.m20211206;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class containsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> ts = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            Long n = (long) nums[i];

            Long h = ts.ceiling(n);
            Long l = ts.floor(n);

            if (h != null && Math.abs(h-n)<=t) return true;
            if (l != null && Math.abs(l-n)<=t) return true;
            ts.add(n);
            if (i>=k) ts.remove((long) nums[i - k]);
        }

        return false;
    }
    int size;
    public boolean containsNearbyAlmostDuplicateBucket(int[] nums, int k, int t) {
        Map<Integer,Long> m = new HashMap<>();
        size = t+1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int idx = getIndex(nums[i]);
            if (m.containsKey(idx)) return true;

            int left = idx-1;
            int right = idx+1;

            if (m.containsKey(left) && Math.abs(m.get(left)-nums[i])<=t) return true;
            if (m.containsKey(right) && Math.abs(m.get(right)-nums[i])<=t) return true;

            m.put(idx, (long) nums[i]);

            if (i>=k) m.remove(getIndex(nums[i-k]));
        }

        return false;
    }

    private int getIndex(int num) {
        return num>=0? num/size:((num+1)/size-1);
    }
}

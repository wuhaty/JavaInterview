package Question.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by gump on 2017/5/21.
 */
public class Q403 {
    public static void main (String argc[]){
        Q403 q = new Q403();
        int stones[] = {0,1,3,5,6,8,12,17};
        q.canCross(stones);
    }

    public boolean canCross(int[] stones) {
        if (stones.length == 0) {
            return true;
        }

        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        map.put(0,new HashSet<>());
        map.get(0).add(1);

        for (int i = 1; i < stones.length; i++) {
            map.put(stones[i],new HashSet<>());
        }

        for (int i = 0; i < stones.length-1; i++) {
            int stone = stones[i];
            for (int step:map.get(stone)) {
                int reach = step +stone;

                if(reach==stones[stones.length-1]) return true;

                HashSet set = map.get(reach);

                if (set!=null){
                    set.add(step);
                    if(step-1>0) set.add(step-1);
                    set.add(step+1);
                }
            }
        }

        return false;
    }

    public boolean canCrossOri(int[] stones) {
        int n = stones.length;
        boolean dp[][] = new boolean[n][n];
        int reach[] = new int[n];

        dp[0][0] = true;
        reach[0] = 1;
        for (int i = 1; i < stones.length; i++) {
            int j = binarySearch(reach,0,i,stones[i]);

            int max = 0;
            for (; j < i; j++) {
                for (int k = 0; k <= i; k++) {
                    if (dp[j][k]){
                        int p = -1;

                        if(stones[j]+k == stones[i]){
                            p=k;
                        }else if(stones[j]+k+1 == stones[i]){
                            p=k+1;
                        }else if(stones[j]+k-1 == stones[i]){
                            p=k-1;
                        }

                        if(p!=-1) {
                            max = Math.max(max,stones[i]+p+1);
                            dp[i][p] = true;
                        }
                    }
                }
            }
            reach[i] = max;
        }
        return reach[n-1] !=0;
    }

    private int binarySearch(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return high;  // key not found.
    }
}

package Question.leetcode;

public class Q875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int p:piles) {
            max = Math.max(max,p);
        }

        if (h == piles.length) return max;

        int l = 0 , r = max;
        while (l<=r){
            int mid = l + (r-l)/2;

            int s = 0;
            for (int p:piles) {
                s += Math.ceil((p+(0.0))/mid);
            }

            if (s>h) {
                l = mid +1;
            }else {
                r = mid-1;
            }
        }

        return l;
    }
}

package Question.leetcode;

/**
 * Created by gump on 2017/7/11.
 */
public class Q11 {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length-1;
        int max = 0;

        while (lo < hi){
            int h = Math.min(height[lo],height[hi]);
            max = Math.max(max,(hi - lo) * h);

            while(height[lo] <= h && lo <hi) lo++;
            while(height[hi] <= h  && lo <hi) hi--;
        }
        return max;
    }

    public int maxArea2021(int[] height) {
        int score = 0;

        int l = 0, r = height.length-1;

        while (l<r) {
            score = Math.max(score,(r-l)*Math.min(height[l],height[r]));

            if (height[r] < height[l]) {
                r--;
            }else{
                l++;
            }
        }
        return score;
    }
}

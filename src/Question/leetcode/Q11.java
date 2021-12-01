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

    public int maxAreaDummy(int[] height) {
        int res = 0;
        int n = height.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j){
                    res = Math.max(res,Math.min(height[i],height[j])*Math.abs(i-j));
                }
            }
        }

        return res;
    }

    public int maxArea2Pointers(int[] height) {
        int l =0,r=height.length-1;
        int res = 0;
        while (l<r){
            int lh = height[l];
            int rh = height[r];

            res = Math.max(res,Math.min(lh,rh)*(r-l));
            if (lh<rh){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}

package Question.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2017/4/23.
 */
public class Q368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int max = 0;

        LinkedList<Integer> dp[] = new LinkedList[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new LinkedList<Integer>();
            dp[i].add(nums[i]);
        }

        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if((nums[i] % nums[j]==0
                        || nums[j] % nums[i]==0) && dp[i].size()<=dp[j].size()){
                    dp[i].clear();
                    dp[i].addAll(dp[j]);
                    dp[i].add(nums[i]);
                }
            }
            if(dp[i].size()>dp[max].size()){
                max = i;
            }
        }
        return dp[max];
    }


    public static void main(String argc[]){
        Q368 q = new Q368();
        int p[] = {488,122,61,366,6};
        q.largestDivisibleSubset(p);
    }

}

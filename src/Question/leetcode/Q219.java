package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2017/5/11.
 */
public class Q219 {

    public static void main(String argc[]){
        Q219 q = new Q219();
        int nums[] ={1,0,1,1};
        q.containsNearbyDuplicate(nums,1);
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                int j = map.get(nums[i]);
                if (Math.abs(i-j)<=k){
                    return true;
                }else {
                    map.put(nums[i],i);
                }
            }
        }
        return false;
    }
}

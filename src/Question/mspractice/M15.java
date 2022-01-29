package Question.mspractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class M15 {

    public static void main(String[] args) {
        M15 q = new M15();
        q.threeSum2Pointer(new int[]{-2,0,0,2,2});
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();

        Arrays.sort(nums);

        for (int first = 0; first < nums.length-1; first++) {
            if (first> 0 && nums[first] == nums[first-1]){
                //only check the first occurrence
                continue;
            }
            if (nums[first] > 0){
                return res;
            }

            for (int second = first + 1; second < nums.length-1; second++) {
                if (second > first+1 && nums[second] == nums[second-1]){
                    //only check the first occurrence
                    continue;
                }

                int target = -nums[first]-nums[second];

                int third = binarySearch(nums,second+1,nums.length-1,target);
                if (third == -1) {
                    continue;
                }else {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[third]);
                    res.add(l);
                }
            }
        }

        return res;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l<=r){
            int mid = (l+r)>>1;

            if (nums[mid] == target) return mid;

            if (nums[mid]<target){
                l = mid+1;
            }else {
                r = mid-1;
            }
        }

        return -1;
    }

    public List<List<Integer>> threeSum2Pointer(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int first = 0; first < nums.length-2; first++) {
            if (nums[first]>0) return res;

            if (first>0 && nums[first] == nums[first-1]) {
                continue;
            }

            int second = first +1 , third = nums.length -1;

            while (second < third){
                int sum = nums[first] + nums[second] + nums[third];

                if (sum>0){
                    third--;
                    while (second<third && nums[third+1] == nums[third]) third--;
                }else if (sum<0){
                    second++;
                    while (second<third && nums[second] == nums[second-1]) second++;
                }else {
                    List<Integer> l = new LinkedList<>();
                    l.add(nums[first]);
                    l.add(nums[second]);
                    l.add(nums[third]);
                    res.add(l);
                    second++;
                    third--;
                    while (second<third && nums[second] == nums[second-1]) second++;
                    while (second<third && nums[third+1] == nums[third]) third--;
                }
            }
        }
        return res;
    }
}

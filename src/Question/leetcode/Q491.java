package Question.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q491 {
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> l = new LinkedList<>();

    public static void main(String[] args) {
        Q491 q = new Q491();
        q.findSubsequences(new int[]{6,7,7});
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums,0,Integer.MIN_VALUE);
        return res;
    }

    private void backtrack(int[] nums,int index,int last) {
        if (index == nums.length) {
            if (l.size()>=2){
                res.add(new ArrayList<>(l));
            }
            return;
        }

        if (nums[index] >= last) {
            l.add(nums[index]);
            backtrack(nums,index+1,nums[index]);
            l.remove(l.size()-1);
        }

        if (nums[index] != last){
            //if got duplicates , only pick the last one. e.g 6777
            //举个栗子 [6 7 7] 对于后面两个7 有4种可能(1代表选) 11 10 01 00 而 01 和 10 是导致重复的原因
            //就等于把10这条路堵住 前面的7被选后 后面的7不能走不选这条路
            backtrack(nums,index+1,last);
        }
    }

    private void backtrack2022(int[] nums,int index,int last) {
        if (index == nums.length) {
            if (l.size()>=2){
                res.add(new ArrayList<>(l));
            }
            return;
        }

        if (index > last){
            l.add(nums[index]);
            backtrack2022(nums,index+1,nums[index]);
            l.remove(l.size()-1);
        }

        if (nums[index] != last){
            backtrack2022(nums,index+1,last);
        }
    }
}

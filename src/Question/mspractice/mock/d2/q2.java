package Question.mspractice.mock.d2;

import Question.leetcode.common.TreeNode;

public class q2 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums,int l, int r) {
        if (l<=r){
            int maxIndex = l;
            for (int i = l; i <=r; i++) {
                if (nums[i]>nums[maxIndex]){
                    maxIndex = i;
                }
            }

            TreeNode n = new TreeNode(nums[maxIndex]);
            n.left= helper(nums,l,maxIndex-1);
            n.right= helper(nums,maxIndex+1,r);
            return n;
        }else {
            return null;
        }
    }
}

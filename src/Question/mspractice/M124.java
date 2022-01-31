package Question.mspractice;

import Question.leetcode.common.TreeNode;

public class M124 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0,maxPathSum(root.left));
        int right = Math.max(0,maxPathSum(root.right));
        max = Math.max(max,left+right+root.val);
        return Math.max(left,right) + root.val;
    }
}

package Question.leetcode;

import Question.leetcode.common.TreeNode;

public class Q124 {

    Integer max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        maxPath(root);

        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(maxPath(root.left),0);
        int right = Math.max(maxPath(root.right),0);

        max = Math.max(max,root.val+left+right);

        return root.val + Math.max(left,right);
    }
}

package Question.mspractice;

import Question.leetcode.common.TreeNode;

public class M543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(left + right,ans);

        return Math.max(left,right)+1;
    }
}

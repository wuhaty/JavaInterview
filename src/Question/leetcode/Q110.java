package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/11.
 */
public class Q110 {

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode root, int height) {
        if (root == null) return height;

        if (res) {

            int l = dfs(root.left, height + 1);
            int r = dfs(root.right, height + 1);

            if (Math.abs(l - r) > 1) {
                res = false;
            }
            return Math.max(l, r);
        }
        return 0;
    }
}

package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/14.
 */
public class Q965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        int key = root.val;

        return dfs(root,key);
    }

    private boolean dfs(TreeNode root, int key) {
        if (root ==null) return true;

        if (root.val != key) return false;

        return dfs(root.left,key) && dfs(root.right,key);
    }
}

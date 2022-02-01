package Question.mspractice;

import Question.leetcode.common.TreeNode;

public class M572 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root,subRoot);
    }

    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return check(root,subRoot) || dfs(root.left,subRoot) || dfs(root.right,subRoot);
    }

    public boolean check(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (root.val == subRoot.val){
            return check(root.left,subRoot.left) && check(root.right,subRoot.right);
        }

        return false;
    }
}

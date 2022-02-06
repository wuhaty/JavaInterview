package Question.mspractice;

import Question.leetcode.common.TreeNode;

public class M226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.Stack;

public class Q285 {
    public TreeNode inorderSuccessorOri(TreeNode root, TreeNode p) {
        if (root == null) return null;

        if (root.val == p.val) {
            TreeNode n = root.right;
            while (n!=null && n.left != null) {
                n = n.left;
            }
            return n;
        }

        TreeNode left = null;
        TreeNode right = null;
        if (p.val > root.val) {
            right = inorderSuccessorOri(root.right,p);
        }

        if (p.val < root.val){
            left = inorderSuccessorOri(root.left,p);
            if (left== null){
                left = root;
            }
        }

        return left == null? right:left;
    }

    TreeNode ans;

    public TreeNode inorderSuccessorRecus(TreeNode root, TreeNode p) {
        helper(root,p);
        return ans;
    }

    private void helper(TreeNode root, TreeNode p) {
        if (root == null) return;

        if (root.left != null) helper(root.left,p);
        if (ans == null && root.val > p.val) {
            ans = root;
            return;
        }
        helper(root.right,p);
    }

    public TreeNode inorderSuccessorIter(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode n = p.right;
            while (n.left != null){
                n = n.left;
            }
            return n;
        }

        Stack<TreeNode> s = new Stack<>();
        int inorder = Integer.MIN_VALUE;

        while (!s.isEmpty() || root!=null){
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            if (inorder == p.val) return root;
            inorder = root.val;
            root = root.right;
        }

        return null;
    }
}

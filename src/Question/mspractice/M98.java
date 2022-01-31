package Question.mspractice;

import Question.leetcode.common.TreeNode;

import java.util.Stack;

public class M98 {

    public static void main(String[] args) {
        M98 m = new M98();
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        m.isValidIter(n2);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val<=minValue || root.val >= maxValue) return false;
        return dfs(root.left,minValue,root.val) && dfs(root.right,root.val,maxValue);
    }

    public boolean isValidIter(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Long pre = Long.MIN_VALUE;

        while (root!=null || !s.isEmpty()) {
            while (root != null){
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            if (root.val <= pre) return false;
            pre = (long) root.val;

            root = root.right;
        }
        return true;
    }

}

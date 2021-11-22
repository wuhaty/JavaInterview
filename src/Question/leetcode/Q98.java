package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by gump on 2021/4/22.
 */
public class Q98 {

    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;

        while (root!= null || !s.isEmpty()){
            while (root!=null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            if (pre!=null && pre.val > root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }


    public static void main(String[] args) {
        Q98 q = new Q98();

        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        q.isValidBST_Iter(n1);
    }

    public boolean isValidBST_Iter(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        Long pre = Long.MIN_VALUE;

        while (!s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }

            TreeNode t = s.pop();
            if (t.val <= pre) return false;
            pre = (long) t.val;
            root = root.right;
        }

        return true;
    }

    public boolean isValidBST_Recur(TreeNode root) {
        return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean helper(TreeNode root, long lower, long upper) {
        if (root == null) return true;

        if (root.val <= lower || root.val >= upper) return false;

        return helper(root.left,lower,root.val) && helper(root.right,root.val,upper);
    }
}

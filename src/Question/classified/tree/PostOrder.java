package Question.classified.tree;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

    List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversalRecursive(TreeNode root) {
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null){
            return;
        }

        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }

    //post Order is the reverse order of mid->right->left
    public List<Integer> postorderTraversalIterative1(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode n = root;

        while (!s.isEmpty() || n != null) {
            while (n!=null){
                res.add(0,n.val);
                s.push(n);
                n = n.right;
            }

            n = s.pop();
            n = n.left;
        }

        return res;
    }

    public List<Integer> postorderTraversalIterative2(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode n = root;
        TreeNode prev = null;

        while (!s.isEmpty() || n != null) {
            while (n!=null) {
                s.push(n);
                n = n.left;
            }

            n = s.pop();


            if (n.right == null || n.right == prev){
                //done with right tree
                res.add(n.val);
                prev=n;
                n=null;
            }else {
                //needs to keep n within the stack
                s.push(n);
                n = n.right;
            }
        }

        return res;
    }
}

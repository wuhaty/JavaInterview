package Question.classified.tree;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Morris Iteration could finish this within time O(n) and constant space
public class InOrder {

    List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        dfs(root);
        return res;
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode n = root;
        while (!s.isEmpty() || n!=null) {
            while (n!=null){
                s.push(n);
                n=n.left;
            }

            n = s.pop();
            res.add(n.val);
            n=n.right;
        }

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
}

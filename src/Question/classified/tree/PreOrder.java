package Question.classified.tree;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//Morris Iteration could finish this within time O(n) and constant space
public class PreOrder {

    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        dfs(root);
        return res;
    }

    public List<Integer> preorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode n = root;

        while (!s.isEmpty() || n != null) {
            while (n!=null){
                res.add(n.val);
                s.push(n);
                n = n.left;
            }
            n = s.pop();
            n = n.right;
        }

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        res.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

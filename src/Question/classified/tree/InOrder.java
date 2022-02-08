package Question.classified.tree;

import Question.leetcode.common.TreeNode;

import java.util.Deque;
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

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> s = new LinkedList<>();
        TreeNode pre = null;

        while (root != null){
            while (root != null){
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            if (pre == p) return root;
            pre = root;
            root = root.right;
        }
        return null;
    }

    public TreeNode inorderSuccessorBST(TreeNode root, TreeNode p) {
        //find the first node which is larger than p.
        TreeNode ans = null;

        while (root != null){
            if (root.val > p.val){
                ans = root;
                root = root.left;
            }else {
                root = root.right;
            }
        }
        return ans;
    }
}

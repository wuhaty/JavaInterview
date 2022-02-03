package Question.mspractice.mock.d7;

import Question.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q1 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;

        while (root!=null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.right == null || root.right == pre){
                pre = root;
                res.add(root.val);
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }

        }
        return res;
    }
}

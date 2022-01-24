package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;

        while (cur !=null || !s.isEmpty()){
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }

            TreeNode n = s.pop();
            res.add(n.val);

            if (n.right != null) {
                cur = n.right;
            }
        }
        return res;
    }
}

package Question.leetcode.mock.m20211208;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        Stack<TreeNode> s = new Stack<>();

        TreeNode l = root;
        while (l!=null){
            s.push(l);
            l=l.left;
        }

        while (!s.isEmpty()){
            TreeNode n = s.pop();
            res.add(n.val);

            if (n.right != null){
                TreeNode r = n.right;
                while (r != null){
                    s.push(r);
                    r = r.left;
                }
            }
        }
        return res;
    }
}

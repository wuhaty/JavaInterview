package Question.mspractice.mock.d6;

import Question.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class q1 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode post = null;
        TreeNode pre = null;
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }

            cur = stack.pop();
            if (cur.val>val){
                post = cur;
                break;
            }else {
                pre = cur;
            }
            cur = cur.right;
        }

        if (post == null){
            TreeNode right = new TreeNode(val);
            pre.right = right;
        }else {
            TreeNode left = post.left;
            post.left = new TreeNode(val);
            post.left.left = left;
        }
        return root;
    }
}

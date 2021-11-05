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
}

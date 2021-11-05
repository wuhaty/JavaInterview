package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.Stack;

/**
 * Created by gump on 2021/4/22.
 */
public class Q230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();

        while (root!=null && !s.isEmpty()) {
            while (root!=null) {
                s.push(root);
                root = root.left;
            }

            root = s.pop();
            k--;
            if (k==0) return root.val;
            root = root.right;
        }
        return -1;
    }
}

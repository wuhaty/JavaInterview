package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gump on 2021/8/14.
 */
public class Q111 {

    public int minDepth(TreeNode root) {
        int res = 0;

        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return 0;

        q.offer(root);
        res = 1;

        while (!q.isEmpty()) {
            int end = q.size();

            while (end-- >0) {
                TreeNode n = q.poll();
                if (n.left == null && n.right == null) return res;
                if (n.left !=null) q.offer(n.left);
                if (n.right !=null) q.offer(n.right);
            }
            res ++;
        }
        return res;
    }
}

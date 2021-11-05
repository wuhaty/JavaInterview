package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gump on 2021/8/11.
 */
public class Q1302 {

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return 0;

        int res = 0;
        q.offer(root);

        while (!q.isEmpty()) {
            int end = q.size();
            res = 0;
            for (int i = 0; i < end; i++) {
                TreeNode n = q.poll();
                res += n.val;
                if (n.left != null) q.offer(n.left);
                if (n.right!= null) q.offer(n.right);
            }
        }

        return res;
    }
}

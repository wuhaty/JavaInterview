package Question.sword;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O32 {
    public int[] levelOrder(TreeNode root) {
        if (root==null) return new int[]{};
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> l = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode n = q.poll();
            l.add(n.val);
            if (null != n.left) {
                q.offer(n.left);
            }

            if (null != n.right) {
                q.offer(n.right);
            }
        }

        int[] res = new int[l.size()];
        int index = 0;
        for (Integer i:l) {
            res[index++] = i;
        }
        return res;
    }
}

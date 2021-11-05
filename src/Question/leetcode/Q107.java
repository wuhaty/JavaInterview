package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by gump on 2021/8/14.
 */
public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);


        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> l = new LinkedList<>();

            while (size -- >0){
                TreeNode n = q.poll();
                l.add(n.val);

                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
            res.add(l);
        }

        Collections.reverse(res);
        return res;
    }
}

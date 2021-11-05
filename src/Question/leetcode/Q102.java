package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by gump on 2017/5/5.
 */
public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;

        queue.offer(root);

        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int limit = queue.size();
            for (int j = 0; j < limit; j++) {
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                temp.add(queue.poll().val);
            }
            result.add(temp);
        }

        return result;
    }


    public List<List<Integer>> levelOrder2020(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();

        if (root == null) return res;
        q.offer(root);

        while (!q.isEmpty()) {
            int s = q.size();
            List<Integer> l = new LinkedList<>();
            while (s>0){
                TreeNode n = q.poll();
                l.add(n.val);
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
                s--;
            }

            res.add(l);
        }

        return res;
    }
}

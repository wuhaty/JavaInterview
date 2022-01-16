package Question.sword;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class O55 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()){
            int size = q.size();
            while (size-->0){
                TreeNode n = q.poll();
                if (n.left!=null) q.offer(n.left);
                if (n.right!=null) q.offer(n.right);
            }
            max++;
        }

        return max;
    }
}

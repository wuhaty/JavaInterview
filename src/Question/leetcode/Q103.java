package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by gump on 2017/5/5.
 */
public class Q103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        travel(root,result,0);
        return result;
    }

    public void travel(TreeNode root, List<List<Integer>> result, int height) {
        if(root==null) return;

        if(height==result.size()){
            result.add(new ArrayList<>());
        }

        if(height %2 ==0){
            result.get(height).add(root.val);
        }else{
            result.get(height).add(0,root.val);
        }
        travel(root.left,result,height+1);
        travel(root.right,result,height+1);
    }

    public static void main(String[] args) {
        Q103 q = new Q103();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n3.right = n5;
        n3.left = n4;
        q.zigzagLevelOrder2021(n1);
    }

    public List<List<Integer>> zigzagLevelOrder2021(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean f = true;
        while (q.size() != 0) {
            int size = q.size();
            int count = 0;
            LinkedList<Integer> l = new LinkedList<>();
            while (count < size) {
                TreeNode n = null;
                n = q.poll();

                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);

                if (f){
                    l.add(n.val);
                }else {
                    l.addFirst(n.val);
                }
                count++;
            }

            res.add(l);
            f = !f;
        }
        return res;
    }
}

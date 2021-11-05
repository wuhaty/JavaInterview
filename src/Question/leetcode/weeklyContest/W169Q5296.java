package Question.leetcode.weeklyContest;

import Question.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by gump on 2019/12/29.
 */
public class W169Q5296 {

    public static void main(String args[]){
        W169Q5296 q = new W169Q5296();
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;

        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(0);
        TreeNode t6 = new TreeNode(3);

        t4.left = t5;
        t4.right = t6;


        q.getAllElements(t1,t4);
    }


    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        PriorityQueue<Integer> q = new PriorityQueue();
        List<Integer> res = new LinkedList<>();

        helper(root1,q);
        helper(root2,q);

        while (!q.isEmpty()){
            res.add(q.poll());
        }

        return res;
    }

    private void helper(TreeNode root1,  PriorityQueue q) {
        if (root1==null) return;
        if (root1.left!= null) helper(root1.left,q);
        q.add(root1.val);
        if (root1.right!= null) helper(root1.right,q);
    }
}

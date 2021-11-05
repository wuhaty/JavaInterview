package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.*;

/**
 * Created by gump on 2017/4/22.
 */
public class Q144 {
    public List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList();
        stack.push(root);
        ArrayList<Integer> result = new ArrayList();
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return result;
    }

    public static void main(String argc[]){
        Q144 q = new Q144();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left= n2;
        n1.right = n3;

        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n2.left = n4;
        n2.right = n5;

        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n3.left = n6;
        n3.right = n7;

        System.out.println(q.preorderTraversal(n1).toArray());
    }


    List<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal2021(TreeNode root) {
        if (root == null) return res;

        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
    }
}

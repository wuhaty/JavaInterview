package Question.mspractice;

import Question.leetcode.common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class M297 {
    String SPLITTER = ",";
    // Encodes a tree to a single string.


    public static void main(String[] args) {
        M297 q = new M297();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        q.deserialize(q.serialize(n1));
    }

    public String serialize(TreeNode root) {
        if (root == null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            while (size-->0){
                TreeNode n = q.poll();
                sb.append(n==null?"x":n.val);
                sb.append(SPLITTER);

                if (n!=null){
                    TreeNode left = n.left;
                    TreeNode right = n.right;
                    q.offer(left);
                    q.offer(right);
                }
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        String[] input = data.split(SPLITTER);

        int i = 1;
        TreeNode res = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(res);

        while (!q.isEmpty()){
            TreeNode n = q.poll();

            TreeNode left = input[i].equals("x") ? null:new TreeNode(Integer.parseInt(input[i]));
            i++;
            TreeNode right = input[i].equals("x") ? null:new TreeNode(Integer.parseInt(input[i]));
            i++;

            n.left = left;
            n.right = right;
            if (left != null) q.offer(n.left);
            if (right != null) q.offer(n.right);
        }
        return res;
    }
}

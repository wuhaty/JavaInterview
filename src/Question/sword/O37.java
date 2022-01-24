package Question.sword;

import Question.leetcode.common.TreeNode;
import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class O37 {

    String splitter = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.toString();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        sb.append(root.val);
        sb.append(splitter);

        while (!q.isEmpty()){
          TreeNode n = q.poll();
          if (n!=null){
              TreeNode left = n.left;
              TreeNode right = n.right;
              q.offer(left);
              q.offer(right);
          }
          sb.append(n==null?"X":n.val);
          sb.append(splitter);
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }


    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String input[] = data.split(splitter);

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 0;
        while (!q.isEmpty()){
            TreeNode n = q.poll();

            i++;
            if (!input[i].equals("X")){
                TreeNode left = new TreeNode(Integer.parseInt(input[i]));
                n.left = left;
                q.offer(left);
            }

            i++;
            if (!input[i].equals("X")){
                TreeNode right = new TreeNode(Integer.parseInt(input[i]));
                n.right = right;
                q.offer(right);
            }
        }

        return root;
    }
}

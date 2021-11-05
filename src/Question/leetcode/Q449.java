package Question.leetcode;

import Question.leetcode.common.TreeNode;

/**
 * Created by gump on 2021/8/19.
 */
public class Q449 {

    public static void main(String[] args) {
        Q449 q = new Q449();
        TreeNode n1 = new TreeNode(1);
        n1.right= new TreeNode(2);
        String s = q.serialize(n1);
        TreeNode n = q.deserialize(s);
    }

    int i = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        preOrder(root,sb);

        return sb.toString();
    }

    private void preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return;

        sb.append(root.val);
        sb.append(',');
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String s[] = data.split(",");
        return helper(s,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode helper(String[] s, int minValue, int maxValue) {
        if (s.length == 0) return null;
        int v = Integer.valueOf(s[i]);
        if (v<minValue || v> maxValue) return null;

        TreeNode n = new TreeNode(v);
        i++;
        if (i<s.length-1){
            n.left = helper(s,minValue,v);
            n.right = helper(s,v,maxValue);
        }
        return n;
    }
}

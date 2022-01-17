package Question.sword;

import Question.leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class O7 {

    public static void main(String[] args) {
        O7 q = new O7();
        int[] i = {3,9,20,15,7};
        int[] ii = {9,3,15,20,7};
        q.buildTree(i,ii);
    }

    Map<Integer,Integer> m = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i],i);
        }

        return build(preorder,inorder,0,preorder.length-1,0,preorder.length);
    }

    private TreeNode build(int[] preorder, int[] inorder, int preL,int preR,int inL, int inR) {
        if (preL>preR || inL>inR) return null;

        TreeNode root = new TreeNode(preorder[preL]);
        int pos = m.get(root.val);
        int leftSubtreeSize = pos - inL;
        root.left = build(preorder,inorder,preL+1,preL+leftSubtreeSize,inL,pos -1);
        root.right = build(preorder,inorder,preL+leftSubtreeSize+1,preR,pos+1,inR);
        return root;
    }


    public TreeNode buildTreeIter(int[] preorder, int[] inorder) {
        if (preorder == null) return null;

        int pre = 0;
        int in = 0;

        TreeNode curNode = new TreeNode(preorder[0]);
        TreeNode root = curNode;
        Stack<TreeNode> s = new Stack<>();
        s.push(curNode);
        pre++;
        while (pre < preorder.length) {
            if (curNode.val == inorder[in]){
                while (!s.isEmpty() && s.peek().val == inorder[in]){
                    curNode = s.peek();
                    s.pop();
                    in++;
                }

                curNode.right = new TreeNode(preorder[pre]);
                curNode = curNode.right;
                s.push(curNode);
            }else {
                TreeNode t = new TreeNode(pre);
                curNode.left = t;
                curNode = t;
                s.push(curNode);
            }
            pre++;
        }

        return root;
    }
}

package Question.leetcode;

import Question.leetcode.common.TreeNode;

public class Q105 {

    int preindex = 0;

    public static void main(String[] args) {
        Q105 q = new Q105();
        int a[] = {3,9,20,15,7};
        int b[] = {9,3,15,20,7};
        q.buildTree2021(a,b);
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;

        return helper(preorder,inorder,0,preorder.length-1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int s, int e) {
        if (s > e) return null;
        if (s==e ) return new TreeNode(preorder[preindex ++]);

        TreeNode n = new TreeNode(preorder[preindex ++]);

        for (int i = s; i <= e; i++) {
            if (inorder[i] == n.val){
                n.left = helper(preorder,inorder,s,i-1);
                n.right = helper(preorder,inorder,i+1,e);
            }
        }

        return n;
    }

    public TreeNode buildTree2021(int[] preorder, int[] inorder) {
        return helper2021(preorder,inorder,0,preorder.length-1,0);
    }

    private TreeNode helper2021(int[] preorder, int[] inorder, int s, int e,int preOrderIndex) {
        if (s>e) {
            return null;
        }
        if (s == e){
            return new TreeNode(preorder[preOrderIndex]);
        }

        TreeNode t = null;
        for (int i = s; i <= e; i++) {
            if (inorder[i] == preorder[preOrderIndex]){
                t = new TreeNode(preorder[preOrderIndex]);
                t.left = helper2021(preorder,inorder,s,i-1,preOrderIndex+1);
                t.right = helper2021(preorder,inorder,i+1,e,preOrderIndex+i-s+1);
                break;
            }
        }

        return t;
    }
}

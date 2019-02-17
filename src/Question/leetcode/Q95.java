package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gump on 2017/4/10.
 */

public class Q95 {


    public List<TreeNode> generateTrees(int n) {
        if(n==0) return null;

        List<TreeNode>[] result = new List[n+1];
        result[0] = new ArrayList<TreeNode>();
        result[0].add(null) ;
        List<TreeNode> init=new ArrayList<>();
        init.add(new TreeNode(1));
        result[1] = init;

        for(int i=2;i<n+1;i++){
            result[i] =new ArrayList<>();
            for(int j=1;j<=i;j++){
                int left = j-1;
                int right = i-j;
                List<TreeNode> leftNode = result[left];
                List<TreeNode> rightNode = result[right];

                if(leftNode!=null && rightNode!=null){
                    for (TreeNode ln:leftNode) {
                        for (TreeNode rn:rightNode) {
                            TreeNode root = new TreeNode(j);
                            root.left = ln;
                            root.right = clone(rn,i-right);
                            result[i].add(root);
                        }
                    }
                }else if(leftNode!=null){
                    for (TreeNode ln:leftNode) {
                        TreeNode root = new TreeNode(j);
                        root.left = ln;
                        result[i].add(root);
                    }
                }else if(rightNode!=null){
                    for (TreeNode rn:rightNode) {
                        TreeNode root = new TreeNode(j);
                        root.right = clone(rn,i-right);
                        result[i].add(root);
                    }
                }



            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    public static void main(String argc[]){
        Q95 q = new Q95();
        System.out.println(q.generateTrees(2));
    }
}

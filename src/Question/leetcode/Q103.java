package Question.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
}

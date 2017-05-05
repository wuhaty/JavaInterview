package Question.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gump on 2017/5/5.
 */
public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return result;

        queue.offer(root);

        while (!queue.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int limit = queue.size();
            for (int j = 0; j < limit; j++) {
                if(queue.peek().left!=null) queue.offer(queue.peek().left);
                if(queue.peek().right!=null) queue.offer(queue.peek().right);
                temp.add(queue.poll().val);
            }
            result.add(temp);
        }

        return result;
    }
}

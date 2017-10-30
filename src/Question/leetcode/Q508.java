package Question.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by gump on 2017/10/30.
 */
public class Q508 {
    static Integer max = Integer.MIN_VALUE;
    public static void main(String argc[]){
        Q508 q= new Q508();
        TreeNode n1 = new TreeNode(5);
//        TreeNode n2 = new TreeNode(2);
//        TreeNode n3 = new TreeNode(-5);
//        n1.left=n2;
//        n1.right=n3;
        q.findFrequentTreeSum(n1);
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        if (root==null) return new int[0];
        List<Integer> result = new LinkedList<>();
        helper(root,new HashMap<>(),result);
        int r[] = new int[result.size()];
        for (int i = 0; i <result.size() ; i++) {
            r[i]= result.get(i);
        }
        return r;
    }

    public static int helper(TreeNode root, Map<Integer,Integer> map,List<Integer> container){
        int result =0;
        if (root.left !=null){
            result+=helper(root.left,map,container);
        }

        if (root.right !=null){
            result+=helper(root.right,map,container);
        }

        result+=root.val;

        if(!map.containsKey(result)){
            map.put(result,1);
        }else{
            map.put(result,map.get(result)+1);
        }

        if(map.get(result)>max){
            container.clear();
            container.add(result);
            max = map.get(result);
        }else if(map.get(result).equals(max)){
            container.add(result);
        }
        return result;
    }
}

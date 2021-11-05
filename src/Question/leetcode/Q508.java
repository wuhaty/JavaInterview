package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

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
        q.findFrequentTreeSum2021(n1);
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


    public int[] findFrequentTreeSum2021(TreeNode root){
        Map<Integer,Integer> occurance = new HashMap<>();
        List<Integer> res = new LinkedList<>();
        postOrder(root,occurance,res);

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    private Integer postOrder(TreeNode root, Map<Integer, Integer> occurance,List<Integer> res) {
        if (root == null) return 0;

        Integer cur = root.val;
        Integer left = postOrder(root.left,occurance,res);
        Integer right = postOrder(root.right,occurance,res);

        Integer s = (cur + left + right);
        occurance.put(s,occurance.getOrDefault(s,0) +1);

        if (occurance.get(s) > max) {
            max = occurance.get(s);
            res.clear();
            res.add(s);
        }else if (occurance.get(s).equals(max)) {
            res.add(s);
        }
        return s;
    }
}

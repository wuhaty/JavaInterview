package Question.leetcode;

import Question.leetcode.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by gump on 2017/5/5.
 */
public class Q108 {

    public static void main(String argc[]){
        int nums[] = {1,2,3,4,5};
        Q108 q = new Q108();
        System.out.println(q.sortedArrayToBST(nums));
    }


    public TreeNode sortedArrayToBST(int[] nums) {

        int len = nums.length;
        if ( len == 0 ) { return null; }

        // 0 as a placeholder
        TreeNode head = new TreeNode(0);

        Deque<TreeNode> nodeStack       = new LinkedList<TreeNode>() {{ push(head);  }};
        Deque<Integer>  leftIndexStack  = new LinkedList<Integer>()  {{ push(0);     }};
        Deque<Integer>  rightIndexStack = new LinkedList<Integer>()  {{ push(len-1); }};

        while ( !nodeStack.isEmpty() ) {
            TreeNode currNode = nodeStack.pop();
            int left  = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid   = left + (right-left)/2; // avoid overflow
            currNode.val = nums[mid];
            if ( left <= mid-1 ) {
                currNode.left = new TreeNode(0);
                nodeStack.push(currNode.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid-1);
            }
            if ( mid+1 <= right ) {
                currNode.right = new TreeNode(0);
                nodeStack.push(currNode.right);
                leftIndexStack.push(mid+1);
                rightIndexStack.push(right);
            }
        }
        return head;
    }




    public TreeNode sortedArrayToBSTOri(int[] nums) {
        return construct(nums,0,nums.length-1);
    }

    private TreeNode construct(int[] nums, int i, int j) {
        if(i>j) return null;

        int mid = (i+j)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = construct(nums,i,mid-1);
        root.right = construct(nums,mid+1,j);

        return root;
    }
}

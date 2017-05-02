package Question.leetcode;

import java.util.PriorityQueue;

/**
 * Created by gump on 2017/5/2.
 */
public class Q215 {
    public static void main(String argc[]){
        Q215 q = new Q215();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(q.findKthLargest(nums,2));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue();
        for (int i:nums) {
            q.offer(i);
            if(q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }
}

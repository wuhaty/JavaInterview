package Question.leetcode;

import java.util.PriorityQueue;

/**
 * Created by gump on 2017/5/2.
 */
public class Q324 {

    public static void main(String argc[]){
        Q324 q = new Q324();
        int[] nums = {1};
        System.out.println(q.wiggleSort(nums));
    }

    public int[] wiggleSort(int[] nums) {
        int mid = findKthLargest(nums,(nums.length+1)/2);
        int n = nums.length;
        int left = 0,i=0;
        int right = n-1;

        while (i<=right){
            if(nums[getIndex(i,n)]>mid){
                swap(nums, getIndex(left++,n), getIndex(i++,n));
            }else if(nums[getIndex(i,n)]<mid){
                swap(nums, getIndex(right--,n), getIndex(i,n));
            }else{
                i++;
            }
        }
        return nums;
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

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int getIndex(int i,int n){
        return ((i<<1)+1)%(n|1);
    }
}

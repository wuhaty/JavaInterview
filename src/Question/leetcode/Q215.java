package Question.leetcode;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by gump on 2017/5/2.
 */
public class Q215 {

    Random random = new Random();

    public static void main(String[] args){
        Q215 q = new Q215();
//        int[] nums = {3,2,3,1,2,4,5,5,6};
        int[] nums = {5,2,4,1,3,6,0};
//        System.out.println(q.findKthLargestPartition(nums,5));
        System.out.println(q.findKthLargestPartition(nums,2));
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

    public int findKthLargestPartition(int[] nums, int k) {
        return quickFilter(nums,0,nums.length-1,nums.length-k);
    }

    private int quickFilter(int[] nums, int l, int r, int k) {
        int index = randomPartition(nums,l,r,k);

        if (index == k) {
            return nums[index];
        }else if (k>index){
            return quickFilter(nums,index+1,nums.length-1,k);
        }else {
            return quickFilter(nums,0,index-1,k);
        }
    }

    private int randomPartition(int[] nums, int l, int r, int k) {
        int i = random.nextInt(r-l+1) +l;
        swap(nums,i,r);
        return partition(nums,l,r,k);
    }

    private int partition(int[] nums, int l, int r, int k) {
        int pos = l;
        int pilot = nums[r];

        for (int i = l; i < r; i++) {
            if (nums[i]<pilot) {
                swap(nums,i,pos);
                pos++;
            }
        }

        swap(nums,r,pos);
        return pos;
    }

    public int findKthLargestHeap(int[] nums, int k) {
        int heapSize = nums.length;

        for (int i = nums.length/2; i >=0 ; i--) {
            maxHeapify(nums,heapSize,i);
        }

        for (int i = nums.length-1; i >=nums.length-k+1; i--) {
            swap(nums,i,0);
            heapSize--;
            maxHeapify(nums,heapSize,0);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int heapSize, int i) {
        int l = (2*i +1);
        int r = (2*i +2);
        int larger = i;

        if (l < heapSize && nums[l] > nums[larger]){
            larger = l;
        }

        if (r < heapSize && nums[r] > nums[larger]){
            larger = r;
        }

        if (larger != i) {
            swap(nums,larger,i);
            maxHeapify(nums,heapSize,larger);
        }
    }


    private void swap(int[] nums, int l, int i) {
        int t = nums[l];
        nums[l] = nums[i];
        nums[i] = t;
    }
}

package Question.mspractice.mock.d9;

import java.util.Random;

public class q2 {
    Random random = new Random();

    public static void main(String[] args) {
        q2 q = new q2();
        q.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4);
    }


    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n-k;
        quickSelect(nums,target,0,nums.length-1);
        return nums[target];
    }

    private void quickSelect(int[] nums, int target, int l, int r) {
        int pivotId = l + random.nextInt(r-l+1);
        swap(nums,l,pivotId);
        int pivot = nums[l];
        int p =l,q=r;

        while (p<q){
            while (p<q && nums[q]>=pivot) q--;
            while (p<q && nums[p]<=pivot) p++;
            swap(nums,p,q);
        }

        swap(nums,l,p);

        if (p==target) return;
        else if (p<target){
            quickSelect(nums,target,p+1,r);
        }else {
            quickSelect(nums,target,l,p-1);
        }
    }

    private void swap(int[] nums, int p, int q) {
        int t = nums[p];
        nums[p] = nums[q];
        nums[q] = t;
    }

}

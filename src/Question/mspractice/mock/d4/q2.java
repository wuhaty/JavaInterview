package Question.mspractice.mock.d4;

import java.util.Arrays;

public class q2 {
    public static void main(String[] args) {
        q2 q = new q2();
//        q.wiggleSort(new int[]{1,4,3,4,1,2,1,3,1,3,2,3,3});
//        q.wiggleSort(new int[]{1,1,2,1,2,2,1});
//        q.wiggleSort(new int[]{1,5,1,1,6,4});
//        q.wiggleSort(new int[]{1,3,2,2,3,1});
        q.wiggleSort(new int[]{2,1,1,2,1,3,3,3,1,3,1,3,2});
    }

    public void wiggleSort(int[] nums) {
        int midIndex = quickSelect(nums,0,nums.length-1);
        int mid = nums[midIndex];

        int n = nums.length;


        int i = 0, j = 0, k = n -1;

        while (j<k){
            if (nums[j] > mid){
                swap(nums,j,k);
                k--;
            }else if (nums[j] < mid){
                swap(nums,j,i);
                i++;
                j++;
            }else {
                j++;
            }
        }

        int midptr = n/2;
        if(nums.length % 2 == 1) ++midptr;
        int[] left = Arrays.copyOfRange(nums,0,midptr);
        int[] right = Arrays.copyOfRange(nums,midptr,nums.length);


        for (int l = 0; l < left.length; l++) {
            nums[2 * l] = left[left.length - l - 1];
        }

        for (int l = 0; l < right.length; l++) {
            nums[2 * l + 1] = right[right.length - l -1];
        }
    }

    private int quickSelect(int[] nums, int l, int r) {
        int pivot = nums[l];

        int p = l, q = r;

        while (p<q){
            while (p<q && nums[q]>=pivot) q--;
            while (p<q && nums[p]<=pivot) p++;
            if (p<q){
                swap(nums,p,q);
            }
        }

        swap(nums,l,p);

        if (p == nums.length/2){
            return p;
        }else if (p > nums.length/2){
            return quickSelect(nums,l,p-1);
        }else {
            return quickSelect(nums,p+1,r);
        }
    }


    private void swap(int[] nums, int j, int k) {
        int t = nums[j];
        nums[j] = nums[k];
        nums[k] = t;
    }

}

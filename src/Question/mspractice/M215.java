package Question.mspractice;

public class M215 {

    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        quickSelect(nums,0,nums.length-1,index);
        return nums[index];
    }

    private void quickSelect(int[] nums, int l, int r, int k) {
        if (l<r){
            int pivot = nums[l];
            int p = l, q = r;

            while (p<q){
                while (p<q && nums[q] >= pivot) q--;
                while (p<q && nums[p] <= pivot) p++;
                swap(nums,p,q);
            }

            swap(nums,l,p);

            if (p == k){
                return;
            }else if (p>k){
                quickSelect(nums,l,p-1,k);
            }else {
                quickSelect(nums,p+1,r,k);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

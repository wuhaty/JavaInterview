package Question.sword;

public class O51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        mergeSort(nums,0,n-1,temp);
        return count;
    }

    private void mergeSort(int[] nums, int l, int r,int[] temp) {
        if (l<r){
            int mid = (l+r)/2;
            mergeSort(nums,l,mid,temp);
            mergeSort(nums,mid+1,r,temp);
            merge(nums,l,mid,r,temp);
        }
    }

    private void merge(int[] nums, int l, int mid, int r, int[] temp) {
        int i = l , j = mid+1;
        int t = 0;
        while (i<=mid && j <=r){

            if (nums[i]<=nums[j]){
                temp[t++] = nums[i++];
            }else {
                count+= (mid-i+1);
                temp[t++] = nums[j++];
            }
        }

        while (i<=mid){
            temp[t++] = nums[i++];
        }

        while (j<=r){
            temp[t++] = nums[j++];
        }

        t = 0;

        while (l <= r){
            nums[l++] = temp[t++];
        }
    }
}

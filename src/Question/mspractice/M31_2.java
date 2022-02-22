package Question.mspractice;

public class M31_2 {

    public static void main(String[] args) {
        M31_2 q = new M31_2();
        q.nextPermutation(new int[]{5,1,1});
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if (i>=0){
            int p = nums.length - 1;
            while (p>i && nums[i]>= nums[p]){
                p--;
            }

            swap(nums, p,i);
        }

        reverse(nums,i+1);
    }


    private void reverse(int[] nums, int start){
        int l = start, r = nums.length -1;
        while (l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int i ,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}

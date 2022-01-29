package Question.mspractice;

public class M31 {
    public static void main(String[] args) {
        M31 m = new M31();
        m.nextPermutation(new int[]{3,2,1});
    }


    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i>=0 && nums[i] >= nums[i+1]){
            i--;
        }

        if (i>=0){
            int j = nums.length-1;

            while (j>i && nums[j]<=nums[i]){
                j--;
            }

            swap(nums,i,j);
        }

        reverse(nums,i+1);
    }

    private void swap(int[] nums, int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums,int i){
        int j = nums.length -1;
        while (i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}

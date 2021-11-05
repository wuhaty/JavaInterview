package Question.leetcode;

/**
 * Created by gump on 2017/7/20.
 */
public class Q26 {

    public static void main(String argc[]){
        Q26 q = new Q26();
        int test[] = {1,1,2};
        q.removeDuplicates(test);
    }

    public int removeDuplicates(int[] nums) {
        if (nums==null || nums.length==0 )return 0;

        int n = nums.length;
        if (n<2) return 1;

        int i = 0;
        for (int j = 1; j < n; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }



    public int removeDuplicates2(int[] nums) {
        if (nums==null || nums.length==0 )return 0;

        int n = nums.length;

        int p=0;
        for (int q=1; q < n; q++) {

            if (nums[p] == nums[q]) continue;
            else {
                nums[p+1] = nums[q];
                p++;
            }

        }

        return p+1;
    }
}

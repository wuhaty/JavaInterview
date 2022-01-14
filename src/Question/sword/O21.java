package Question.sword;

public class O21 {
    public int[] exchange(int[] nums) {
        int odd = 0, even = nums.length-1;

        while (odd < even){
            if (nums[odd] % 2 == 1) {
                odd++;
                continue;
            }
            if (nums[even] % 2 ==0) {
                even--;
                continue;
            }

            int t = nums[odd];
            nums[odd] = nums[even];
            nums[even] = t;
            odd++;
            even--;
        }

        return nums;
    }
}

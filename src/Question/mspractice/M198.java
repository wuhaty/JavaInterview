package Question.mspractice;

public class M198 {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;

        for (int i = 0; i < nums.length; i++) {
            int t = notRob;
            notRob = Math.max(notRob,rob);
            rob = t + nums[i];
        }

        return Math.max(rob,notRob);
    }
}

package Question.mspractice;

public class M213 {
    public int rob(int[] nums) {
        int rob = 0;
        int notRob = 0;

        for (int i = 0; i < nums.length-1; i++) {
            int t = notRob;
            notRob = Math.max(notRob,rob);
            rob = t + nums[i];
        }

        int first = Math.max(rob,notRob);
        rob = 0;
        notRob = 0;

        for (int i = 1; i < nums.length; i++) {
            int t = notRob;
            notRob = Math.max(notRob,rob);
            rob = t + nums[i];
        }

        return Math.max(Math.max(rob,notRob),first);
    }
}

package Question.leetcode;

/**
 * Created by gump on 2017/4/20.
 */
public class Q198 {
    public int rob(int[] nums) {
        return Math.max(robWay(nums,0,nums.length-2),robWay(nums,1,nums.length-1));
    }

    public int robWay(int[] nums,int lo,int hi) {
        int preNo= 0;
        int preYes=0;

        for (int i = lo; i <= hi; i++) {
            int temp = preNo;
            preNo=Math.max(preNo,preYes);
            preYes = nums[i] + temp;
        }
        return Math.max(preNo,preYes);
    }

    public int rob2021(int[] nums) {
        return Math.max(robRecur(1, nums),robRecur(0,nums));
    }

    private int robRecur(int i, int[] nums) {
        int preNo = 0;
        int preYes = 0;

        for (int j = 0; j < nums.length; j++) {
            int temp = preNo;
            preNo = Math.max(preNo,preYes);
            preYes = temp+nums[j];
        }

        return Math.max(preNo,preYes);
    }

    public static void main(String argc[]){
        Q198 q = new Q198();
//        int t[] = {2,1,1,1};
        int t[] = {1,2,3,1};
        q.rob2021(t);
    }
}

package Question.mspractice.mock.d5;

public class q1 {

    public int getMaxLen(int[] nums) {
        int max = 0;

        int prePos = 0, preNeg = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==0){
                prePos =0;
                preNeg =0;
            }else if (nums[i] >0 ){
                prePos++;
                if (preNeg!=0) preNeg++;
            }else {
                int t = preNeg;
                preNeg = prePos+1;
                prePos = t == 0? 0:t+1;
            }

            max = Math.max(max,prePos);
        }
        return max;
    }
}

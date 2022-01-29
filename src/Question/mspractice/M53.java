package Question.mspractice;

public class M53 {
    public int maxSubArray(int[] nums) {
        int preSum = 0, max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            preSum = Math.max(preSum+nums[i],nums[i]);
            max = Math.max(preSum,max);
        }

        return max;
    }


    class Status{
        public int iSum, lSum,rSum,mSum;

        public Status(int iSum, int lSum, int rSum, int mSum) {
            this.iSum = iSum;
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
        }
    }

    public int maxSubArrayStatus(int[] nums) {
        return query(nums,0,nums.length-1).mSum;
    }

    private Status query(int[] nums, int l, int r) {
        if (l<r){
            int mid = (l+r)>>1;

            Status lStatus = query(nums,l,mid);
            Status rStatus = query(nums,mid+1,r);

            return pushUp(lStatus,rStatus);
        }else {
            return new Status(nums[l],nums[l],nums[l],nums[l]);
        }
    }

    private Status pushUp(Status lStatus, Status rStatus) {
        int iSum = lStatus.iSum + rStatus.iSum;
        int lSum = Math.max(lStatus.lSum,lStatus.iSum + rStatus.lSum);
        int rSum = Math.max(rStatus.rSum,rStatus.iSum + lStatus.rSum);
        int mSum = Math.max(Math.max(lStatus.mSum, rStatus.mSum), lStatus.rSum+ rStatus.lSum);
        return new Status(iSum,lSum,rSum,mSum);
    }

}

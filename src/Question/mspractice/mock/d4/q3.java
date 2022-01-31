package Question.mspractice.mock.d4;


public class q3 {

    int MOD = 1000000007;

    public int maxSum(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0 , j = 0;
        long best1 = 0,best2= 0;

        while (i < n || j < m){
            if (i < n && j < m){
                if (nums1[i] < nums2[j]){
                    best1+=nums1[i++];
                }else if (nums1[i] > nums2[j]){
                    best2+=nums2[j++];
                }else {
                    long best = Math.max(best1,best2) + nums1[i];
                    best1 = best;
                    best2 = best;
                    i++;
                    j++;
                }
            }else if (i<n){
                best1+=nums1[i++];
            }else if (j<m){
                best2+=nums2[j++];
            }
        }

        return (int) (Math.max(best1,best2) % MOD);
    }
}

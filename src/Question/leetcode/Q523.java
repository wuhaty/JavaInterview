package Question.leetcode;



/**
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous subarray of size at least 2
 * that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
 *
 * Example 1:
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 */
public class Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int result[] =new int[nums.length+1];
        for(int i =1;i<result.length;i++){
            result[i] = result[i-1] + nums[i-1];
        }

        for(int i =0;i<result.length;i++){
            for(int j =i+2;j<result.length;j++){
                if(k==0 ){
                    if(result[j]-result[i]==0)
                        return true;
                }else{
                    if((result[j]-result[i])%k ==0) return true;
                }
            }
        }
        return false;
    }

    public static void main(String argc[]){
        Q523 q = new Q523();
        int array[] = {23, 2, 6};
        System.out.println(q.checkSubarraySum(array,6));
    }
}
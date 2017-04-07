package Question.leetcode;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 */
public class Q303 {
    int data[][] = null;
    public Q303(int[] nums) {
        data = new int[nums.length+1][nums.length+1];
        for(int i = 0;i<nums.length+1;i++){
            data[0][i]=0;
            data[i][0]=0;
        }

        for(int i =1 ;i<data.length;i++){
            for(int j = i;j<data[0].length;j++){
                data[i][j] = data[i][j-1]+nums[j-1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return data[i+1][j+1];
    }

    public static void main(String argc[]){
        int nums[] ={-2,0,3,-5,2,-1};
        Q303 obj = new Q303(nums);
        System.out.println(obj.sumRange(0,5));
    }
}

package Question.leetcode;

public class Q167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l=0,r=numbers.length-1;

        while (l<r){
            int sum = (numbers[l]+numbers[r]);
            if (sum == target) {
                res[0] = l;
                res[1] = r;
                return res;
            }

            if (sum>target) {
                r--;
            }else {
                l++;
            }
        }
        return res;
    }
}

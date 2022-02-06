package Question.mspractice.mock.d8;

import java.util.HashMap;
import java.util.Map;

public class q1 {

    int nums[];
    int bucket[];
    int bucketSize;

    public q1(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        double len = Math.sqrt(n);
        bucketSize = (int) Math.ceil(len);
        bucket = new int[(int) Math.ceil(n/len)];

        for (int i = 0; i < n; i++) {
            bucket[i/bucketSize] += nums[i];
        }
    }

    public void update(int index, int val) {
        int oldVal = nums[index];
        nums[index] = val;
        int bucketIndex = index/bucketSize;
        bucket[bucketIndex] -= oldVal;
        bucket[bucketIndex] += val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right;) {
            if (i%bucketSize==0 && i+bucketSize<=right){
                sum+=bucket[i/bucketSize];
                i+=bucketSize;
            }else{
                sum+=nums[i++];
            }
        }
        return sum;
    }
}

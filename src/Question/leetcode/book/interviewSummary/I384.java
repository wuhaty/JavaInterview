package Question.leetcode.book.interviewSummary;

import java.util.Arrays;
import java.util.Random;

public class I384 {

    int[] original;
    Random random;
    public I384(int[] nums) {
        original = Arrays.copyOf(nums,nums.length);
        random = new Random();
    }

    public int[] reset() {
        return original;
    }

    public int[] shuffle() {
        int[] res = new int[original.length];
        int[] temp = Arrays.copyOf(original,original.length);

        int k = original.length;
        for (int i = 0; i < original.length; i++) {
            int index = random.nextInt(k);
            swap(temp,k-1,index);
            res[i] = temp[k-1];
            k--;
        }
        return temp;
    }

    private void swap(int[] temp, int p, int q) {
        int t = temp[p];
        temp[p] = temp[q];
        temp[q] = t;
    }


    public static void main(String[] args) {
        I384 q = new I384(new int[]{1,2,3});
        int[] r = q.shuffle();
        r = q.reset();
    }
}

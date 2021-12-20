package Question.leetcode;

public class Q307 {

    int bit[];
    int arr[];

    private int lowBit(int x) {
        return x&-x;
    }

    public Q307(int[] nums) {
        arr = nums;
        bit = new int[nums.length +1];

        for (int i = 0; i < nums.length; i++) {
            add(i+1,nums[i]);
        }
    }

    private void add(int i, int num) {
        while (i < bit.length){
            bit[i] += num;
            i += lowBit(i);
        }
    }

    public void update(int index, int val) {
        arr[index] = val;
        add(index+1,val-arr[index]);
    }

    public int sumRange(int left, int right) {
        return query(right+1) - query(left);
    }

    private int query(int index) {
        int sum = 0;
        while (index>=1){
            sum+= bit[index];
            index -=lowBit(index);
        }
        return sum;
    }
}

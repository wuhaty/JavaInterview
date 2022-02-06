package Question.mspractice.mock.d8;

public class q1_BinaryIndexedTree {

    int tree[];

    private int lowBit(int x){
        return x&(-x);
    }

    private void add(int x,int index){
        for (int i = index; i <=n; i+=lowBit(i)) {
            tree[i]+=x;
        }
    }

    private int query(int range){
        int sum = 0;
        while (range>0){
            sum += tree[range];
            range-=lowBit(range);
        }
        return sum;
    }

    int[] nums;
    int n;


    public q1_BinaryIndexedTree(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n+1];

        for (int i = 0; i < nums.length; i++) {
            add(nums[i],i+1);
        }
    }

    public void update(int index, int val) {
        add(val-nums[index],index+1);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right+1) - query(left);
    }
}

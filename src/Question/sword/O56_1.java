package Question.sword;

public class O56_1 {
    public static void main(String[] args) {
        O56_1 q = new O56_1();
        int n[] = {1,2,5,2};
        q.singleNumbers(n);
    }
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        int[] res = new int[2];
        for(int i: nums){
            k^=i;
        }

        int l = 0,r=0;
        int t =1;
        while (((k & t) ==0)){
            t<<=1;
        }

        for (int i:nums) {
            if ((t&i)!=0){
                l^=i;
            }else {
                r^=i;
            }
        }

        res[0] = l;
        res[1] = r;
        return res;
    }
}

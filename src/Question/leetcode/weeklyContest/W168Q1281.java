package Question.leetcode.weeklyContest;

/**
 * Created by gump on 2019/12/26.
 */
public class W168Q1281 {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;


        while (n>0){
            int t = n % 10;
            n /=10;

            sum +=t;
            product*=t;
        }

        return product-sum;
    }
}

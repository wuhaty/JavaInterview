package Question.leetcode;

/**
 * Created by gump on 2017/5/7.
 */
public class Q264 {
    public static void main(String argc[]){
        Q264 q= new Q264();
        System.out.println(q.nthUglyNumber(11));
    }

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }

    public int nthUglyNumberOri(int n) {
        if (n==1) return 1;
        int result[] = new int[n];
        result[0] = 1;

        int index2=0;
        int index3=0;
        int index5=0;

        for (int i = 1; i < result.length; i++) {
            result[i] = Math.min(Math.min(2*result[index2],3*result[index3]),5*result[index5]);

            while (index2<=i && 2*result[index2]<=result[i]){
                index2++;
            }
            while (index3<=i && 3*result[index3]<=result[i]){
                index3++;
            }
            while (index5<=i && 5*result[index5]<=result[i]){
                index5++;
            }
        }
        return result[n-1];
    }
}

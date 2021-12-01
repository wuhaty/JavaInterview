package Question.leetcode;

public class Q50 {

    public static void main(String[] args) {
        Q50 q = new Q50();
        q.myPow(2.0,-2147483648);
    }


    public double myPow(double x, int n) {
        double ans = 1.0;
        double x_contribute = x;
        boolean flag = false;
        long n2 = n;
        if (n2>=0){
            flag = true;
        }else{
            n2= (-n2);
        }

        while (n2>0){
            if (n2%2 ==1){
                ans *= x_contribute;
            }

            x_contribute *= x_contribute;
            n2/=2;
        }
        return flag?ans:1.0/ans;
    }

    public double myPowRecur(double x, int n){
        long n2 = n;
        return n2>=0? recur(x,n2):1.0/recur(x,n2);
    }

    private double recur(double x, long n2) {
        if (n2 == 0) return 1;

        double y = recur(x,n2/2);

        return n2%2 ==0? y*y:y*y*x;
    }

}

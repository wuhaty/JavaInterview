package Question.sword;

public class O10_1 {
    public static void main(String[] args) {
        O10_1 q = new O10_1();
        q.fib(4);
    }

    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int pre = 1;
        int prepre = 0;
        int x =2;
        int res = 1;
        while (x<=n){
            res = (pre + prepre) % 1000000007;
            prepre = pre;
            pre = res;
            x++;
        }

        return res;
    }
}

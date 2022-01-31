package Question.mspractice.mock.d4;

public class q1 {
    public int addDigits(int num) {
        if (num==0) return 0;
        int res = num;

        while (res>=10){
            int t = 0;
            while (res>0){
                t += res%10;
                res/=10;
            }
            res = t;
        }

        return res;
    }
}

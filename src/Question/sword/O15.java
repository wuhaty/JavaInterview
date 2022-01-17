package Question.sword;

public class O15 {
    public static void main(String[] args) {
        O15 q = new O15();
        q.hammingWeight(-3);
    }

    public int hammingWeight(int n) {
        int count = 0;

        int limit = 32;
        while (limit>0){
            int t = n&1;
            count +=t;
            n>>=1;
            limit--;
        }

        return count;
    }

    public int hammingWeightOpt(int n) {
        int count = 0;

        while (n!=0){
            n &= n-1;
            count++;
        }

        return count;
    }
}

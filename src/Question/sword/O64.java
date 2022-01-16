package Question.sword;

public class O64 {
    public int sumNums(int n) {
        return n == 0? 0:n + sumNums(n-1);
    }
}

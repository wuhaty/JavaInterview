package Question.leetcode.mock.m20211206;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class isHappy {
    public static void main(String[] args) {
        isHappy q = new isHappy();
        q.isHappy(2);
    }

    public boolean isHappy(int n) {
        HashSet<Integer> s = new HashSet<>();

        while (!s.contains(n)){
            int sum = 0;
            s.add(n);
            while (n>0){
                int t = n%10;
                sum += (t*t);
                n/=10;
            }
            if (sum == 1) return true;
            n=sum;
        }

        return false;
    }
}

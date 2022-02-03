package Question.mspractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class M202 {

    public static void main(String[] args) {
        M202 q = new M202();
        q.isHappy(2);
    }


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)){
            set.add(n);
            int s = 0;
            while (n>0){
                int k = n%10;
                s+=k*k;
                n/=10;
            }
            if (s==1)return true;
            n = s;
        }

        return false;
    }
}

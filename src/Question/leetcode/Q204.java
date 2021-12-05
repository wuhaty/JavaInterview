package Question.leetcode;

import java.util.Arrays;

public class Q204 {


    public int countPrimesEratosthenes(int n) {
        int ans = 0;
        boolean isPrime[] = new boolean[n];
        Arrays.fill(isPrime,true);

        for (int i = 2; i <n; i++) {
            if (isPrime[i]) {
                ans ++;
                if (i*i<n){
                    for (int j = i; j <n ; j+=i) {
                        isPrime[j] = false;
                    }
                }

            }
        }
        return ans;
    }

    public int countPrimesTLE(int n) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (isPrime(i)) ans++;
        }

        return ans;
    }

    private boolean isPrime(int i) {
        for (int j = 0; j*j <i; j++) {
            if (i %j ==0) {
                return false;
            }
        }
        return true;
    }
}

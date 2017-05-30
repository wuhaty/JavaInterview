package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2017/5/28.
 */
public class Q600 {

    public static void main (String argc[]){
        Q600 q = new Q600();
        q.findIntegersDP(9);
    }

    public static int findIntegers(int num) {
        return findIntegersDFS(num, new HashMap<>());
    }


    public int findIntegersDP(int num) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num)).reverse();
        int n = sb.length();

        int a[] = new int[n];
        int b[] = new int[n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++) {
            a[i] = a[i - 1] + b[i - 1];
            b[i] = a[i - 1];
        }

        int result = a[n - 1] + b[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '1') break;
            if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '0') result -= b[i];
        }

        return result;
    }

    public static int findIntegersDFS(int num, HashMap<Integer,Integer> map) {
        if (num<2) return num+1;
        if (map.containsKey(num)) return map.get(num);


        int msb = 31 - Integer.numberOfLeadingZeros(num);
        int left = (1 << msb) - 1;

        int right = num & ~(1 << msb - 1);
        if (right >= (1 << msb - 1)) right = left >>1;
        int result = findIntegersDFS(left,map) + findIntegersDFS(right,map);
        map.put(num,result);

        return result;
    }



    public int findIntegersMLE(int num) {
        boolean dp[] = new boolean[num+1];
        dp[0] = true;
        dp[1] = true;
        int sum =2;

        for (int i = 2; i < num+1; i++) {
            if (dp[i/2]){
                if (i%2==0 || (i/2)%2==0){
                    dp[i] = true;
                    sum++;
                }
            }
        }
        return sum;
    }
}

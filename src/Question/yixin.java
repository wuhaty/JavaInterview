package Question;

import java.util.*;
public class yixin{

    static long temp = 0;
    public static void main(String argc[]){
        Scanner sc = new Scanner(System.in);
        int mod = 100003;
        temp = 0;
        while(sc.hasNext()){
            long N = sc.nextLong();
            long W = sc.nextLong();
            long sum = (long) Math.pow((double)N,(double)W);

            System.out.println((sum-dfs(0,-1,N,W,0)) % mod);
        }
    }

    private static long dfs(int pos, int left, long n, long w,int result) {
        if (pos==w){
            return 1;
        }

        for (int i = 0; i < n; i++) {
            if (i!=left){
                result += dfs(pos+1,i,n,w,result);
            }
        }
        return result;
    }
}
package Question.leetcode;

/**
 * Created by gump on 2017/9/14.
 */
public class Q667 {

    public static void main(String argc[]){
        Q667 q = new Q667();
        q.constructArray(5,2);
    }

    public int[] constructArray(int n, int k) {
        int result[] =new int[n];
        int cur = 0;
        int end = result.length;
        int l = 1;
        int r = n;
        while (cur<end){
            if (cur<k){
                if (cur%2==0){
                    result[cur++] = l++;
                }else{
                    result[cur++] = r--;
                }
            }else{
                if (cur%2==1){
                    while (l<=r){
                        result[cur++] = l++;
                    }
                }else{
                    while (l<=r){
                        result[cur++] = r--;
                    }
                }
            }
        }
        return result;
    }
}

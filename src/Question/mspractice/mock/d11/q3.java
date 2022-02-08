package Question.mspractice.mock.d11;

public class q3 {
    public static void main(String[] args) {
        q3 q = new q3();
        q.longestMountain(new int[]{2,1,4,7,3,2,5});
    }


    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;

        int i = 0,n= arr.length,ans = 0;

        while (i<n){
            int p = i , q = i;
            while (p<n-1 && arr[p+1]>arr[p]) p++;
            q=p;
            while (q<n-1 && arr[q+1]<arr[q]) q++;


            if (i == p && i ==q) {
                i++;continue;
            }

            if (p-i != 0 && q - p != 0){
                ans = Math.max(ans,q-i+1);
            }
            i = q;
        }
        return ans;
    }
}

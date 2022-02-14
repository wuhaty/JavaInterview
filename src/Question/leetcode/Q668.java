package Question.leetcode;

public class Q668 {
    public int findKthNumber(int m, int n, int k) {
        int l = 1, r = m*n;
        int ans = l;
        while (l<r){
            int mid = l + (r-l)/2;

            if (enough(m,n,mid,k)){
                ans = mid;
                r = mid;
            }else {
                l = mid +1;
            }
        }

        return ans;
    }

    private boolean enough(int m, int n, int mid, int k) {
        int count = 0, j =n;
        for (int i = 1; i < m; i++) {
            while (i *j>mid){
                j--;
            }
            count += j;

            if (count>=k){
                return true;
            }
        }
        return false;
    }
}

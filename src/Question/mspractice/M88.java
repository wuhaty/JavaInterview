package Question.mspractice;

public class M88 {

    public static void main(String[] args) {
        M88 q = new M88();
        q.merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length == 0) return;
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        for (int i = 0; i < m; i++) {
            nums1[n+m-i-1] = nums1[m-i-1];
        }

        int k = 0, i = n,j=0;

        while (j<n && i< n+m){
            if (nums1[i] < nums2[j]){
                nums1[k++] = nums1[i++];
            }else {
                nums1[k++] = nums2[j++];
            }
        }

        while (j<n){
            nums1[k++] = nums2[j++];
        }
        while (i<n+m){
            nums1[k++] = nums1[i++];
        }
    }

    public void mergeOpt(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1, q=n-1;
        int t = m+n-1;
        while (p>=0 || q >=0){
            if (p == -1){
                nums1[t--] = nums2[q--];
            }else if (q == -1){
                nums1[t--] = nums1[p--];
            }else if (nums1[p] > nums2[q]){
                nums1[t--] = nums1[p--];
            }else {
                nums1[t--] = nums2[q--];
            }
        }
    }
}

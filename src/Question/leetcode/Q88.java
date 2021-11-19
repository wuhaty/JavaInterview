package Question.leetcode;

/**
 * Created by gump on 2017/10/14.
 */
public class Q88 {

    public static void main(String[] args) {
        Q88 q = new Q88();
        int n1[] = {1,2,3,0,0,0};
        int n2[] = {2,5,6};
        q.merge2021(n1,3,n2,3);
        System.out.println(n1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i =0,j=0,k=0;
        int temp[] = new int[m+n];

        while (j<n || i<m){
            if (i==m){
                temp[k++] = nums2[j++];
                continue;
            }

            if (j==n){
                temp[k++] = nums1[i++];
                continue;
            }

            if (nums1[i] <= nums2[j]){
                temp[k++] = nums1[i++];
            }else {
                temp[k++] = nums2[j++];
            }
        }

        i=0;
        for (Integer in:temp) {
            nums1[i++] = in;
        }
    }

    public void merge2021(int[] nums1, int m, int[] nums2, int n) {
        int p = m-1;
        int q = n-1;
        int tail = m+n-1;

        while (p>=0 || q >= 0) {
            if (p==-1){
                nums1[tail--] = nums2[q--];
            }else if (q == -1){
                nums1[tail--] = nums1[p--];
            }else if (nums1[p]>nums2[q]){
                nums1[tail--] = nums1[p--];
            }else {
                nums1[tail--] = nums2[q--];
            }
        }
    }
}

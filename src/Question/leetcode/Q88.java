package Question.leetcode;

/**
 * Created by gump on 2017/10/14.
 */
public class Q88 {
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
}

package Question.leetcode;

/**
 * Created by gump on 2021/7/2.
 */
public class Q4 {
    public double findMedianSortedArraysMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n == 0) {
            if (m % 2 == 0){
                return (nums2[m/2] +nums2[m/2 -1 ])/ 2.0;
            }else {
                return nums2[m/2];
            }
        }

        if (m == 0) {
            if (n % 2 == 0){
                return (nums1[n/2] +nums1[n/2 -1 ])/ 2.0;
            }else {
                return nums1[n/2];
            }
        }

        int count = 0,i=0,j =0;
        int nums[] = new int[m+n];
        while (count != (m+n)) {
             if (i == n) {
                 nums[count++] = nums2[j++];
                 continue;
             }

             if (j==m) {
                 nums[count++] = nums1[i++];
                 continue;
             }

             if (nums1[i] > nums2[j]) {
                 nums[count++] = nums2[j++];
             }else {
                 nums[count++] = nums1[i++];
             }
        }

        return count%2 == 0? ((nums[count/2] +nums[count/2 -1 ])/ 2.0) : nums[count/2];
    }


    public static void main(String[] args) {
        int[] n1 = {1,3};
        int[] n2 = {2};
        Q4 q = new Q4();
        System.out.println(q.findMedianSortedArraysOptimized(n1,n2));
    }

    public double findMedianSortedArraysSpaceReduced(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if (n == 0) {
            if (m % 2 == 0){
                return (nums2[m/2] +nums2[m/2 -1 ])/ 2.0;
            }else {
                return nums2[m/2];
            }
        }

        if (m == 0) {
            if (n % 2 == 0){
                return (nums1[n/2] +nums1[n/2 -1 ])/ 2.0;
            }else {
                return nums1[n/2];
            }
        }

        int aStart = 0,bStart = 0;
        int count = 0;
        int pre = 0, current = 0;

        while (count <= ((m+n)/2)) {
            pre = current;

            if (aStart < n && (bStart >= m || nums1[aStart] < nums2[bStart])) {
                current = nums1[aStart++];
            }else{
                current = nums2[bStart++];
            }
            count++;
        }

        return (m+n) %2 ==0? (pre+current)/2.0:current;
    }

    public double findMedianSortedArraysOptimized(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        if ((m+n)%2==0) {
            return (getKth(nums1,0,n-1,nums2,0,m-1,(m+n)/2) + getKth(nums1,0,n-1,nums2,0,m-1,(m+n)/2+1))/2.0;
        }else{
            return getKth(nums1,0,n-1,nums2,0,m-1,(m+n)/2+1);
        }

    }

    public double getKth(int nums1[], int start1, int end1,int nums2[], int start2,int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;


        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2+k-1];

        if (k ==1) return Math.min(nums1[start1],nums2[start2]);

        int i = start1 + Math.min(len1,k/2) -1;
        int j = start2 + Math.min(len2,k/2) -1;

        if (nums1[i] < nums2[j]) {
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1)-1);
        }else{
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2)-1);
        }

    }
}

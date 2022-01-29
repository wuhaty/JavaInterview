package Question.mspractice;

import java.util.PriorityQueue;

public class M4 {
    public static void main(String[] args) {
        M4 m = new M4();
        m.findMedianSortedArrays(new int[]{3},new int[]{-2,-1});
    }


    public double findMedianArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> larger = new PriorityQueue<>();
        PriorityQueue<Integer> smaller = new PriorityQueue<>((o1,o2) -> o2 - o1);


        int n1 = nums1.length;
        int n2 = nums2.length;
        int k=0,p1=0,p2 =0;

        int[] nums = new int[n1+n2];
        while (p1 < n1 && p2< n2){
            if (nums1[p1] < nums2[p2]){
                nums[k++] = nums1[p1++];
            }else {
                nums[k++] = nums2[p2++];
            }
        }

        while (p1 < n1){
            nums[k++] = nums1[p1++];
        }

        while (p2 < n2){
            nums[k++] = nums2[p2++];
        }


        for (int i = 0; i < nums.length; i++) {
            if (smaller.size() != larger.size()){
                if (nums[i] > smaller.peek()){
                    larger.offer(nums[i]);
                }else {
                    int t = smaller.poll();
                    smaller.offer(nums[i]);
                    larger.offer(t);
                }
            }else {
                if (smaller.size() == 0 || nums[i] < smaller.peek()){
                    smaller.offer(nums[i]);
                }else {
                    int t = larger.poll();
                    larger.offer(nums[i]);
                    smaller.offer(t);
                }
            }
        }



        if (larger.size() == smaller.size()){
            return (larger.peek() + smaller.peek())/2.0;
        }else {
            return smaller.peek();
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        //Median is either the (n+m)/2 th element or (n+m)/2 -1 th element

        if ((n+m) % 2 ==0){
            int midIndexl = (n+m)/2-1;
            int midIndexr = (n+m)/2;
            return (getKthElement(nums1,nums2,midIndexl+1) + getKthElement(nums1,nums2,midIndexr+1))/2.0;
        }else {
            int midIndex = (n+m)/2;
            return getKthElement(nums1,nums2,midIndex+1);
        }
    }



    private double getKthElement(int[] nums1, int[] nums2,int k){
        int i = 0 , j = 0;

        while (true){
            if (i == nums1.length) {
                return nums2[j+k-1];
            }

            if (j == nums2.length){
                return nums1[i+k-1];
            }

            if (k==1) return Math.min(nums1[i],nums2[j]);

            int half = k/2;
            int newIndex1 = Math.min(nums1.length,i+half)-1;
            int newIndex2 = Math.min(nums2.length,j+half)-1;
            int pivot1 = nums1[newIndex1],pivot2 = nums2[newIndex2];

            if (pivot1<=pivot2){
                k-=(newIndex1-i+1);
                i = newIndex1+1;
            }else {
                k-=(newIndex2-j+1);
                j = newIndex2+1;
            }
        }
    }
}

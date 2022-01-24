package Question.sword;

import java.util.*;
import java.util.stream.IntStream;

public class O59 {

    public static void main(String[] args) {
        O59 q = new O59();
//        q.maxSlidingWindow(new int[]{5,3,4},1);
//        q.maxSlidingWindow2021(new int[]{1,3,1,2,0,5},3);
        q.maxSlidingWindow2021(new int[]{9,10,9,-7,-4,-8,2,-6},5);
//        q.maxSlidingWindow2021(new int[]{1,3,-1,-3,5,3,6,7},3);
        List<Integer> l = new LinkedList<>();
    }


    public int[] maxSlidingWindow2021(int[] nums, int k) {
        int n = nums.length;
        if (nums.length==0) return new int[]{};

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair2[0] - pair1[0];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                //if the peek element is not within i-k, then it should not be included in the current round of result.
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new int[]{};
        int[] res = new int[nums.length-k+1];

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
        int left = 0, right = k-1;
        int maxIndex = 0;
        int i =0;
        for (; i <k; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
            q.offer(i);
        }
        q.poll();
        res[0] = nums[maxIndex];

        for (int j = 1; j < res.length; j++) {
            right++;

            if (maxIndex == left){
                if (!q.isEmpty()){
                    maxIndex = q.poll();
                }else {
                    maxIndex = right;
                }
            }
            q.remove(left);
            left++;
            if (nums[right] > nums[maxIndex]){
                q.offer(maxIndex);
                maxIndex = right;
            }else {
                q.offer(right);
            }
            res[left] = nums[maxIndex];
        }
        return res;
    }
}

package Question.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Q84 {

    public static void main(String[] args) {
        Q84 q = new Q84();
        q.largestRectangleArea(new int[]{6,7,5,2,4,5,9,3});
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>(n);

        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }

            left[i] = stack.isEmpty()? -1:stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = heights.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }

            right[i] = stack.isEmpty()? n:stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max,heights[i] * (right[i] - left[i] -1));
        }


        return max;
    }
}

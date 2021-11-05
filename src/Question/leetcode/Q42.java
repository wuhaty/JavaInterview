package Question.leetcode;

/**
 * Created by gump on 2021/6/27.
 */
public class Q42 {

    public static void main(String[] args) {
        Q42 q = new Q42();
        int[] j = {4,2,0,3,2,5};
        q.trap(j);
    }

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left[] = new int[n];
        int right[] = new int[n];

        left[0] = height[0];
        right[n-1] = height[n-1];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1],height[i]);
        }

        for (int i = n-2; i >=0 ; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }

        int sum =0;
        for (int i = 0; i < n; i++) {
            sum += (Math.min(left[i],right[i]) - height[i]);
        }
        
        
        return sum;
    }

    public int trap2Pointer(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int left = 0;
        int right = n -1;
        int leftMax = height[0];
        int rightMax = height[n-1];
        int sum = 0;
        while (left<right) {
            leftMax = Math.max(height[left],leftMax);
            rightMax = Math.max(height[right],rightMax);

            if(leftMax<rightMax) {
                sum += (leftMax-height[left]);
                left++;
            }else{
                sum += (rightMax-height[right]);
                right--;
            }
        }
        return sum;
    }

}

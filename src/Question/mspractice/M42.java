package Question.mspractice;

public class M42 {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int sum = 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
            rightMax[n-i-1] = Math.max(rightMax[n-i],height[n-i-1]);
        }

        for (int i = 0; i < n; i++) {
            sum+=(Math.min(leftMax[i],rightMax[i])-height[i]);
        }

        return sum;
    }

    public int trap2Pointers(int[] height) {
        int n = height.length;
        if(n == 0) return 0;

        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        int l = 0,r = n-1;

        while (l<r){
            leftMax = Math.max(leftMax,height[l]);
            rightMax = Math.max(rightMax,height[r]);

            if (height[l]<height[r]){
                sum+=leftMax-height[l];
                l++;
            }else {
                sum+=rightMax-height[r];
                r--;
            }
        }

        return sum;
    }
}

package Question.leetcode.weeklyContest;

public class W193Q1482 {

    public static void main(String[] args) {
        W193Q1482 q = new W193Q1482();

        int t[] = {7,7,7,7,12,7,7};
        q.minDays(t,2,3);
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        if (m * k > n) return -1;

        int left = 0;
        int right = Integer.MAX_VALUE;

        while (left<right){
            int mid = (left + right) /2;
            int bouq = 0;
            int score = 0;
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] <= mid) {
                    score++;
                    if(score >= k){
                        score = 0;
                        bouq++;
                    }
                }else {
                    score = 0;
                }
            }

            if (bouq < m) {
                left = mid+1;
            }else{
                right = mid;
            }
        }

        return left;
    }
}

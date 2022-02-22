package Question.mspractice.mock.d13;

public class q1 {
    public int minEatingSpeed(int[] piles, int h) {
        int r = 0;
        for (int p:piles) {
            r = Math.max(r,p);
        }

        int l = 1;

        while (l<r){
            int mid = l + (r-l)/2;
            int time = 0;

            for (int p:piles) {
                time += Math.ceil(p/(mid+0.0));
            }

            if (time >= h){
                r = mid;
            }else {
                l = mid +1;
            }
        }

        return l;
    }
}

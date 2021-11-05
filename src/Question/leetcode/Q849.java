package Question.leetcode;

public class Q849 {

    public static void main(String args[]){
        Q849 q = new Q849();
        int[] t = new int[]{0,0,0,0,0,0,0,0,1,1,0,0};
        q.maxDistToClosest(t);
    }



    public int maxDistToClosest(int[] seats) {
        int maxD = 0;
        int pre = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1){
                if (pre == -1 ){
                    pre = i;
                    maxD = Math.max(maxD,i);
                    continue;
                }else {
                    if (i - pre > 1){
                        maxD = Math.max(maxD , (i - pre)/2);
                    }
                    pre =  i;
                }
            }else{
                if (i == seats.length -1){
                    maxD = Math.max(Math.abs(seats.length-1-pre),maxD);
                }
            }
        }

        return maxD;
    }
}

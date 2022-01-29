package Question.mspractice.mock.d2;

import java.util.PriorityQueue;

public class q1 {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int i = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2)->o2-o1);
        while (i<heights.length-1){
            if (heights[i+1]>heights[i]){
                int gap = heights[i+1] - heights[i];
                q.offer(gap);
                bricks-=gap;

                if (bricks<0){
                    if (ladders==0) break;
                    int preMax = q.poll();
                    ladders--;
                    bricks += preMax;
                }

            }
            i++;
        }

        return i;
    }
}

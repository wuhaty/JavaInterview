package Question.mspractice;

import java.util.Random;

public class M973 {
    Random rand = new Random();
    public int[][] kClosest(int[][] points, int k) {
        int index = k-1;
        quickSelect(points,0,points.length-1,index);

        int[][] res = new int[k][];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private void quickSelect(int[][] points, int l, int r, int index) {
        if (l<r){
            int pivotId = l + rand.nextInt(r - l + 1);
            int pivot = getScore(points[pivotId]);
            swap(points,r,pivotId);

            int i = l -1;
            for (int j = l; j < r; j++) {
                int dist = getScore(points[j]);
                if (dist<=pivot){
                    i++;
                    swap(points,i,j);
                }
            }

            i++;
            swap(points,i,r);

            if (i == index){
                return;
            }else if (i>index){
                quickSelect(points,l,i-1,index);
            }else {
                quickSelect(points,i+1,r,index);
            }
        }
    }

    private int getScore(int[] p) {
        return (p[0] * p[0] + p[1] *p[1]);
    }

    private void swap(int[][] points, int i ,int j){
        int[] t = points[i];
        points[i] = points[j];
        points[j] = t;
    }
}

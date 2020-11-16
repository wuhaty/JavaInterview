package Question.leetcode;

/**
 * Created by gump on 2018/4/9.
 */
public class Q812 {

    public static void main(String args[]){
        Q812 q = new Q812();
        int points[][] = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        q.largestTriangleArea(points);
    }

    public double largestTriangleArea(int[][] points) {
        Double res = 0.0;
        int temp[][] = new int[3][2];
        return helper(res, points, 0, 0,temp);
    }

    private double helper(Double res, int[][] points, int i,int start, int[][] t) {
        if (i == 3) {
            double s = (1.0 / 2) * Math.abs(t[0][0] * t[1][1] + t[1][0] * t[2][1] + t[2][0] * t[0][1] - t[0][0] * t[2][1] - t[1][0] * t[0][1] - t[2][0] * t[1][1]);
            return s;
        }

        for (int j = start; j < points.length; j++) {
            t[i] = new int[2];
            t[i][0] = points[j][0];
            t[i][1] = points[j][1];
            res = Math.max(helper(res,points,i+1,j+1,t),res);
        }
        return res;
    }
}

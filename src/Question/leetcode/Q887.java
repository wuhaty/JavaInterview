package Question.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gump on 2018/8/12.
 */
public class Q887 {
    public static void  main(String args[]){
        Q887 q = new Q887();

        int test[][] = {{2}};
        q.projectionArea(test);

    }

    public int projectionArea(int[][] grid) {
        int xy = 0,xz=0,yz=0;

        Map<Integer,Integer> xzMax = new HashMap<>();
        Map<Integer,Integer> yzMax = new HashMap<>();
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                int z = grid[x][y];
                if (z>0) xy++;
                if (xzMax.containsKey(x)){
                    int oldv = xzMax.get(x);
                    if (z > oldv){
                        xz -= oldv;
                        xzMax.put(x,z);
                        xz += z;
                    }
                }else{
                    xzMax.put(x,z);
                    xz += z;
                }

                if (yzMax.containsKey(y)){
                    int oldv = yzMax.get(y);
                    if (z > oldv){
                        yz -= oldv;
                        yzMax.put(y,z);
                        yz += z;
                    }
                }else{
                    yzMax.put(y,z);
                    yz += z;
                }
            }
        }

        return xy+xz+yz;
    }
}

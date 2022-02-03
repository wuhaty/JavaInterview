package Question.mspractice;

import javax.swing.plaf.IconUIResource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class M994 {

    int[][] dirs = {
            {-1,0},
            {1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        M994 q = new M994();
//        int[][] grid = {
//                {1,2,2,2,0},{2,1,1,1,0}
//        };
        int[][] grid = {
                {2,2},{1,1},{0,0},{2,0}
        };
        q.orangesRottingByfloor(grid);
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<>();
        int remain = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    remain++;
                }else if (grid[i][j] == 2){
                    map.put(i*m+j,0);
                    q.offer(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()){
            int[] l = q.poll();
            int x = l[0],y = l[1];

            for (int[] dir:dirs) {
                int nx = x+dir[0];
                int ny = y+dir[1];
                if (nx >= 0 && ny >=0 && nx < n && ny < m && grid[nx][ny] == 1){
                    grid[nx][ny] = 2;
                    remain--;
                    q.offer(new int[]{nx,ny});
                    map.put(nx*m+ny,map.get(x*m+y)+1);
                    ans = Math.max(ans,map.get(nx*m+ny));
                }
            }
        }

        return remain == 0? ans:-1;
    }


    public int orangesRottingByfloor(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        Queue<int[]> q = new LinkedList<>();
        int remain = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    remain++;
                }else if (grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
            }
        }

        int count = -1;
        while (!q.isEmpty()){
            int size = q.size();
            while (size-->0){
                int[] l = q.poll();
                int x = l[0],y = l[1];
                for (int[] dir:dirs) {
                    int nx = x+dir[0];
                    int ny = y+dir[1];

                    if (nx >= 0 && ny >=0 && nx < n && ny < m && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        remain--;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
            count++;
        }
        ans = Math.max(ans,count);
        return remain == 0? ans:-1;
    }

}

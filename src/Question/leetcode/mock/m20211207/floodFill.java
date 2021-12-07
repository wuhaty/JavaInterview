package Question.leetcode.mock.m20211207;

import java.util.HashSet;

public class floodFill {
    int targetColor = -1;
    int dirs[][] = {
            {1,0},
            {-1,0},
            {0,-1},
            {0,1}
    };

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        targetColor = image[sr][sc];
        dfs(image,sr,sc,newColor);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int newColor) {
        if (i< 0 || i>=image.length || j<0 || j>=image[0].length) return;
        //not target or already visited
        if (image[i][j] != targetColor || image[i][j] == newColor) return;

        image[i][j] = newColor;

        for (int[] dir:dirs) {
            dfs(image,i+dir[0],j+dir[1],newColor);
        }
    }
}

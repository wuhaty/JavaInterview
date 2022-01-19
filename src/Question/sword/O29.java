package Question.sword;

public class O29 {
    int[][] dirs = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
    };
    public int[] spiralOrder(int[][] matrix) {
        int n = matrix.length;
        if (n==0) return new int[]{};
        int m = matrix[0].length;

        int[] res = new int[n*m];
        boolean[][] visited = new boolean[n][m];

        int i = 0,j=0;
        int dirIndex = 0;
        for (int count = 0; count < res.length; count++) {
            int nr = i + dirs[dirIndex][0];
            int nc = j + dirs[dirIndex][1];
            visited[i][j] = true;
            res[count] = matrix[i][j];
            if (nr<0 || nc <0 || nr >=n || nc >=m || visited[nr][nc]){
                dirIndex = (dirIndex+1)%4;
            }
            i += dirs[dirIndex][0];
            j += dirs[dirIndex][1];
        }

        return res;
    }
}

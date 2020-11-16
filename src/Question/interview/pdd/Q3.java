package Question.interview.pdd;

/**
 * Created by gump on 2017/11/9.
 */
public class Q3 {
    static int result = 0;

    public static int q3(char[][] map) {
        if (map==null || map[0] ==null) return 0;
        boolean visited[][] = new boolean[map.length][map[0].length];
        helper(map,0,0,visited);
        return result;
    }

    private static void helper(char[][] map, int i, int j, boolean[][] visited) {
        if (map[i][j] == 'X' && !visited[i][j]) {
            result++;
            visited[i][j] = true;
        }

        if (move(0) && i>0 && !visited[i-1][j]) helper(map,i-1,j,visited);
        if (move(1) && i<map.length-1 && !visited[i+1][j]) helper(map,i+1,j,visited);
        if (move(2) && j>0 && !visited[i][j-1]) helper(map,i,j-1,visited);
        if (move(3) && j<map[0].length-1 && !visited[i][j+1]) helper(map,i,j+1,visited);
    }

    public static boolean move(int direction){
        return false;
    }
}

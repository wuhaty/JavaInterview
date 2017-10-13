package Question.interview.didi;

/**
 * Created by gump on 2017/9/23.
 */
import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int k = in.nextInt();

            boolean map[][] = new boolean[m][n];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                map[in.nextInt()][in.nextInt()] = true;
                sb.append(checkLands(map));
                if (i!=k-1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    private static int checkLands(boolean[][] map) {
        int count = 0;
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] && !visited[i][j]){
                    dfs(map,visited,i,j);
                    boolean up = i == 0 || !map[i - 1][j] || visited[i-1][j];
                    boolean down = i == map.length-1 || !map[i + 1][j] || visited[i+1][j];
                    boolean left = j == 0 || !map[i][j -1] || visited[i][j-1];
                    boolean right = j == map[0].length-1 || !map[i][j + 1] || visited[i][j+1];
                    if (up && down && left && right) count++;
                }
            }
        }
        return count;
    }

    private static void dfs(boolean[][] map, boolean[][] visited, int i, int j) {
        if (i>=map.length || i<0 || j>=map[0].length || j<0 || !map[i][j] ) return;
        visited[i][j] = true;

        if (i>0 && !visited[i-1][j]) dfs(map,visited,i-1,j);
        if (i<map.length-1 && !visited[i+1][j]) dfs(map,visited,i+1,j);
        if (j>0 && !visited[i][j-1]) dfs(map,visited,i,j-1);
        if (j<map[0].length-1 && !visited[i-1][j+1]) dfs(map,visited,i,j+1);
    }
}
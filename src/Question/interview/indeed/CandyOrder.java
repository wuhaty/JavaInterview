package Question.interview.indeed;

import java.util.Scanner;

/**
 * Created by gump on 2017/5/27.
 */
public class CandyOrder {
    public static void main(String argc[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int a[][] = new int[t][3];
        for (int i = 0; i < t; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
            a[i][2] = sc.nextInt();
        }

        System.out.println(dfs(a, 0, n, 0,false,false));
        System.out.flush();
    }

    private static int dfs(int a[][], int max, int stock, int index,boolean isTwo,boolean isThree) {
        if (stock < 0) {
            if (isTwo) return max -2;
            if (isThree) return max-3;
            else return max - 1;
        }
        if (index >= a.length) return max;

        int result = max;

        if (a[index][0]>stock && a[index][1]>stock && a[index][2]>stock){
            result = Math.max(result, dfs(a, max, stock,index+1,false,false));
        }else{
            result = Math.max(result, dfs(a, max + 1, stock - a[index][1], index + 1,false,false));
            result = Math.max(result, dfs(a, max + 1, stock - a[index][0], index + 1,false,false));
            result = Math.max(result, dfs(a, max + 1, stock - a[index][2], index + 1,false,false));
            result = Math.max(result, dfs(a, max + 2, stock - a[index][0] - a[index][1], index + 1,true,false));
            result = Math.max(result, dfs(a, max + 2, stock - a[index][0] - a[index][2], index + 1,true,false));
            result = Math.max(result, dfs(a, max + 2, stock - a[index][1] - a[index][2], index + 1,true,false));
            result = Math.max(result, dfs(a, max + 3, stock - a[index][0] - a[index][1] - a[index][2], index + 1,false,true));
        }



        return result;
    }
}

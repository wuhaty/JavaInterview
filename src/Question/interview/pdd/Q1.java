package Question.interview.pdd;

/**
 * Created by gump on 2017/11/9.
 */
public class Q1 {

    public static void q1(int m[][]){
        if (m==null) return;
        
        int i=0,j=m[0].length-1;

        int max = 0;

        while (m[i][j]==1){
            if (j>0 && m[i][j-1]==1){
                max++;
                j--;continue;
            }

            if (i<m.length && m[i+1][j] ==1 ){
                max++;
                i++;continue;
            }
            if (j==0 || (m[i][j-1] ==0 && m[i+1][j]==0)) break;
        }

        while (i<m.length){
            if (m[i][j]==1) {
                System.out.printf("[%d,%d]",i+1,max);
                i++;
            }
        }
    }
}

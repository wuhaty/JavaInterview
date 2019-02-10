package Question.leetcode.weeklyContest;

public class W122Q985 {

    public static void main(String args[]){
        int a[] = {1,2,3,4};
        int queries[][] = {{1,0},{-3,1},{-4,0},{2,3}};

        W122Q985 q = new W122Q985();

        int result[] = q.sumEvenAfterQueries(a,queries);
        for (int i : result) {
            System.out.println(i);
        }
    }


    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int init = 0;
        int result[] = new int[queries.length];
        for (int i:A) {
            if (i%2 ==0) init+=i;
        }

        int k = 0;
        for (int j[]:queries) {
            int change = A[j[1]] + j[0];
            if (change %2 == 0){
                if (A[j[1]] % 2 != 0) init += change;
                else init = init - A[j[1]] + change;
            }else{
                if (A[j[1]] %2 ==0){
                    init -= A[j[1]];
                }
            }
            result[k++] = init;
            A[j[1]] += j[0];
        }
        return result;
    }
}

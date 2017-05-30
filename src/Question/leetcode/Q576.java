package Question.leetcode;

import java.util.HashMap;

/**
 * Created by gump on 2017/5/29.
 */
public class Q576 {

    int mod = 1000000007;

    public static void main(String argc[]){
        Q576 q = new Q576();
        q.findPaths(1,3,3,0,1);
    }

    class Record{
        Integer i;
        Integer j;
        Integer n;

        public Record(Integer i, Integer j, Integer n) {
            this.i = i;
            this.j = j;
            this.n = n;
        }

        @Override
        public int hashCode() {
            return i.hashCode() + j.hashCode()*17 + n.hashCode()*23;
        }

        @Override
        public boolean equals(Object obj) {
            Record r = (Record) obj;
            return r.i == this.i && r.j == this.j && r.n == this.n ;
        }
    }

    private int findPaths(int m, int n, int N, int i, int j) {
        return dfs(m,n,N,i,j,new HashMap<>());
    }

    public int dfs(int m, int n, int N, int i, int j, HashMap<Record,Integer> map) {
        Record r = new Record(i,j,N);
        if (map.containsKey(r)) return map.get(r);

        if (N<0) return 0;
        if (outOfBound(i,j,m,n)) return 1;
        if (N == 0) return 0;

        long up = dfs(m,n,N-1,i-1,j,map);
        long down = dfs(m,n,N-1,i+1,j,map);
        long left = dfs(m,n,N-1,i,j-1,map);
        long right = dfs(m,n,N-1,i,j+1,map);

        int result = (int)((up + down + left + right) % mod);
        map.put(r,result);

        return result;
    }

    private boolean outOfBound(int i, int j, int m, int n) {
        return i>m-1 || i<0 || j>n-1 || j<0;
    }
}

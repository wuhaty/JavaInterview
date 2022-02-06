package Question.mspractice.mock.d10;

import java.util.*;

public class q2 {
    List<Integer> factors;
    List<Integer> path;
    List<List<Integer>> res;
    public static void main(String[] args) {
        q2 q = new q2();
        q.getFactors(32);
    }

    public List<List<Integer>> getFactors(int n) {
        factors = new ArrayList<>();
        res = new LinkedList<>();
        path = new LinkedList<>();
        if (n==1) return res;
        for (int i = 2; i <= n/2; i++) {
            if (n%i == 0) {
                factors.add(i);
            }
        }

        dfs(n,0);
        return res;
    }

    private void dfs(int n,int index) {
        if (n==1){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < factors.size() && factors.get(i)<n; i++) {
            if (n % factors.get(i) == 0){
                path.add(factors.get(i));
                dfs(n/factors.get(i),i);
                path.remove(path.size()-1);
            }
        }
    }



    public List<List<Integer>> getFactors2(int n) {
        return dfs2(n,2);
    }

    private List<List<Integer>> dfs2(int n, int i) {
        List<List<Integer>> res = new LinkedList<>();

        for (int j = i; j * j <= n; j++) {
            if (n % j ==0){
                List<Integer> tmp = new LinkedList<>();
                tmp.add(j);
                tmp.add(n/j);
                res.add(tmp);

                for (List<Integer> l:dfs2(n/j,j)) {
                    l.add(j);
                    res.add(new ArrayList<>(l));
                }
            }
        }
        return res;
    }
}

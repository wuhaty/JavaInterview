package Question.mspractice.mock.d10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

interface CustomFunction {
    default int f(int x, int y) {
        return x+y;
    };
};

public class q1 {
    public static void main(String[] args) {
        q1 q = new q1();
        q.findSolution(new CustomFunction() {
            @Override
            public int f(int x, int y) {
                return x+y;
            }
        },5);
    }
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new LinkedList<>();

        int l = 1, r = 1000;
        while (l <= 1000 && r >= 1) {
            int f = customfunction.f(l,r);
            if (f==z){
                res.add(Arrays.asList(l,r));
                l++;
            }else if (f<z){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
}

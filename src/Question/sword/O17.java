package Question.sword;

public class O17 {
    public int[] printNumbers(int n) {
        double end = Math.pow(10,n);
        int[] res = new int[(int) end -1];

        for (int i = 1; i < end; i++) {
            res[i] = i;
        }

        return res;
    }

    int start;
    int nine;
    char[] cs;
    int[] res;
    int count =0;

    public static void main(String[] args) {
        O17 q = new O17();
        q.printNumbersBigNumber(3);
    }


    public int[] printNumbersBigNumber(int n) {
        int size = (int) (Math.pow(10,n)-1);
        res = new int[size];
        cs = new char[n];
        start = n-1;
        nine = 0;

        dfs(0,n);

        return res;
    }

    private void dfs(int i, int n) {
        if (i == n) {
            String str = String.valueOf(cs).substring(start);
            if (!str.equals("0")){
                res[count++] = Integer.parseInt(str);
            }
            if (start + nine == n) start--;
            return;
        }

        for (int j = 0; j <= 9; j++) {
            if (j==9) nine++;
            char c = (char) ('0' + j);
            cs[i] = c;
            dfs(i+1,n);
        }
        nine--;
    }
}

package Question.sword;

public class O17_2 {
    int[] res;
    int p = 0;
    public int[] printNumbers(int n) {
        res = new int[(int) (Math.pow(10,n)-1)];

        for (int i = 1; i <= n; i++) {
            for (char first = '1'; first <= '9' ; first++) {
                char[] num = new char[i];
                num[0] = first;
                dfs(1,num,i);
            }
        }

        return res;
    }

    private void dfs(int index, char[] num, int digit) {
        if (index == digit){
            res[p++] = Integer.parseInt(String.valueOf(num));
            return;
        }

        for (char c = '0'; c <= '9' ; c++) {
            num[index] = c;
            dfs(index+1,num,digit);
        }
    }
}

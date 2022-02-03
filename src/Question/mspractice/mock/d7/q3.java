package Question.mspractice.mock.d7;

public class q3 {
    int max = 0;

    public static void main(String[] args) {
        q3 q = new q3();
        System.out.println(q.checkValidStringDP("(*))"));
    }

    public boolean checkValidString(String s) {
        char[] cs = s.toCharArray();
        int l = 0, r = 0, star = 0, n = cs.length;

        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') {
                l++;
            } else if (cs[i] == ')') {
                if (l == 0) r++;
                else l--;
            } else {
                star++;
            }

            if (star + l < r && l < r) {
                return false;
            }
        }

        star = 0;
        l = 0;
        r = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (cs[i] == ')') {
                r++;
            } else if (cs[i] == '(') {
                if (r == 0) l++;
                else r--;
            } else {
                star++;
            }
            if (star + r < l && r < l) {
                return false;
            }
        }
        return true;
    }

    public boolean checkValidStringDP(String s) {
        int n = s.length();
        boolean[][] f = new boolean[n + 1][n + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            for (int j = 0; j <= i; j++) {
                if (c == '(') {
                    if (j - 1 >= 0) f[i][j] = f[i - 1][j - 1];
                } else if (c == ')') {
                    if (j + 1 <= i) f[i][j] = f[i - 1][j + 1];
                } else {
                    f[i][j] = f[i - 1][j];
                    if (j - 1 >= 0) f[i][j] |= f[i - 1][j - 1];
                    if (j + 1 <= i) f[i][j] |= f[i - 1][j + 1];
                }
            }
        }
        return f[n][0];
    }

    public boolean checkValidStringOpt(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        int l = 0,r=0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '('){
                l++;r++;
            }else if (cs[i] == ')'){
                l--;r--;
            }else {
                l--;r++;
            }
            l = Math.max(0,l);
            if (l>r) return false;
        }

        return l==0;
    }
}

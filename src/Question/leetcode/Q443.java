package Question.leetcode;

public class Q443 {

    public static void main(String[] args) {
        Q443 q = new Q443();
        char[] c = {'a','a','b','b','c','c','c'};
        q.compress(c);
    }
    public int compress(char[] chars) {
        int r = 0;
        int w = 0;
        int n = chars.length;

        while (r < n) {
            int count = 1;
            while (r+1<n && chars[r] == chars[r+1]){
                count++;
                r++;
            }

            chars[w] = chars[r];
            w++;
            if (count>1) {
                char[] num = String.valueOf(count).toCharArray();

                for (int i = 0; i < num.length; i++) {
                    chars[w] = num[i];
                    w++;
                }
            }
            r++;
        }

        return w+1;
    }
}

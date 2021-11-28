package Question.leetcode;

public class Q168 {
    public static void main(String[] args) {
        Q168 q = new Q168();
        q.convertToTitle(701);
    }


    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber>0){
            columnNumber--;
            int n = columnNumber%26;
            sb.append((char)('A'+n));
            columnNumber/=26;
        }

        return sb.reverse().toString();
    }
}

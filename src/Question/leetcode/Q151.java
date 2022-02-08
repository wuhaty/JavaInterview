package Question.leetcode;

public class Q151 {

    public static void main(String[] args) {
        Q151 q = new Q151();
        String res = q.reverseWords("  Bob    Loves  Alice   ");
        assert res.equals("Alice Loves Bob");
        System.out.println("Success");
    }

    public String reverseWords(String s) {
        if (s == null) return s;
        s = s.trim();
        String[] input = s.split("\\s+");
        int start = 0;
        int end = input.length - 1;

        while (start<end){
            String t = input[start];
            input[start] = input[end];
            input[end] = t;
            start++;
            end--;
        }
        return String.join(" ",input);
    }

    public String reverseWord2(String s) {
        if (s == null) return s;
        s = s.trim();

        char[] cs = s.toCharArray();
        reverse(cs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length;) {
            int j = i;
            while (j<cs.length && Character.isLetterOrDigit(cs[j])) j++;

            char[] temp = new String(cs,i,j-i+1).toCharArray();
            reverse(temp);
            sb.append(temp);
            sb.append(" ");
            while (j<cs.length && cs[j] == ' ') j++;
            i=j;
        }

        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    private void reverse(char[] cs){
        int l = 0, r= cs.length-1;
        while (l<r){
            char t = cs[l];
            cs[l] = cs[r];
            cs[r] = t;
            l++;r--;
        }
    }
}

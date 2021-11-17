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
}

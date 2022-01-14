package Question.sword;

public class O58_1 {
    public static void main(String[] args) {
        O58_1 q = new O58_1();
        q.reverseWords("a good   example");
    }
    public String reverseWords(String s) {
        if (s == null) return null;

        s = s.trim();

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length-1; i >=0 ; i--) {
            String str = strings[i];
            if (str.isEmpty()) continue;
            sb.append(str);
            if (i != 0){
                sb.append(" ");
            }
        }

        return sb.toString();
    }
}

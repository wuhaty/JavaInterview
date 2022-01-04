package Question.sword;

public class O58 {
    public String reverseLeftWords(String s, int n) {
        int l = s.length();
        return s.substring(n,l) + s.substring(0,n);
    }
}

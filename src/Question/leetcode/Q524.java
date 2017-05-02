package Question.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gump on 2017/5/2.
 */
public class Q524 {
    public static void main(String argc[]) {
        Q524 q = new Q524();
        String s = "abpcplea", d[] = {"ale", "apple", "monkey", "plea"};

        System.out.println(q.findLongestWord(s, Arrays.asList(d)));
    }

    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String word : d) {
            int i = 0;
            for (Character c : s.toCharArray()) {
                if (i < word.length() && c == word.charAt(i)) i++;
            }

            if (i == word.length() && word.length() >= result.length()) {
                if (word.length() > result.length() || result.compareTo(word) > 0) result = word;
            }
        }
        return result;
    }

    public String findLongestWordWithSort(String s, List<String> d) {
        Collections.sort(d,(a,b)-> a.length() != b.length() ? -Integer.compare(a.length(), b.length()):a.compareTo(b));
        for (String word : d) {
            int i =0;
            for (Character c:s.toCharArray()) {
                if(i<word.length() && word.charAt(i)==c){
                    i++;
                }
                if(i==word.length()) return word;
            }
        }
        return "";
    }
}

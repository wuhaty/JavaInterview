package Question.leetcode.book.interviewSummary;

import java.util.*;

public class I140 {

    public static void main(String[] args) {
        I140 q = new I140();
        q.wordBreak("pineapplepenapple",Arrays.asList("apple","pen","applepen","pine","pineapple"));
    }



    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<Integer, List<List<String>>> m = new HashMap<>();
        List<List<String>> ans = backTrack(s,0,set,m);
        List<String> res = new LinkedList<>();

        for (List<String> l:ans) {
            res.add(String.join(" ",l));
        }
        return res;
    }

    private List<List<String>> backTrack(String s, int index, Set<String> set, Map<Integer, List<List<String>>> m) {
        if (!m.containsKey(index)){

            List<List<String>> wordBreaks = new LinkedList<>();
            if (index == s.length()) {
                wordBreaks.add(new LinkedList<String>());
            }

            for (int i = index; i < s.length(); i++) {
                String word = s.substring(index,i+1);
                if (set.contains(word)){
                    List<List<String>> remain = backTrack(s,i+1,set,m);
                    for (List<String> l:remain) {
                        List<String> rep = new LinkedList<>(l);
                        rep.add(0,word);
                        wordBreaks.add(rep);
                    }
                }
            }
            m.put(index,wordBreaks);
        }
        return m.get(index);
    }
}

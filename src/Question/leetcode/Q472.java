package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/6/15.
 */
public class Q472 {

    public static void main(String argc[]){
        Q472 q = new Q472();
        String word[] = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        q.findAllConcatenatedWordsInADict(word);
    }


    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        Set<String> preWords = new HashSet<>();
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i],preWords)){
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> preWords) {
        if (preWords.isEmpty()) return false;
        boolean dp[] = new boolean[word.length()+1];
        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) continue;
                if (preWords.contains(word.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}

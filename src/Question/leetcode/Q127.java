package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2021/7/11.
 */
public class Q127 {

    HashSet<String> visited = new HashSet<>();
    Integer result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Q127 q = new Q127();

        String s[] = {"hot","dot","dog","lot","log","cog"};
        List<String> l = Arrays.asList(s);
        q.ladderLengthAns("hit",
                "cog",new LinkedList<>()
                );
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        visited.add(beginWord);

        return backtrack(beginWord,endWord,wordList);
    }


    public int backtrack(String beginWord, String endWord, List<String> wordList) {
        if (endWord.equals(beginWord)) return visited.size();
        if (!wordList.contains(endWord)) return 0;

        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (!visited.contains(s)
                    && distance(beginWord,s)) {
                visited.add(s);

                int res = backtrack(s,endWord,wordList);
                if (res>0) {
                    result = Math.min(result,res);
                }
                visited.remove(s);
            }
        }

        return result == Integer.MAX_VALUE? 0:result;
    }

    private boolean distance(String beginWord, String s) {
        int count = 0;
        char[] c1 = beginWord.toCharArray();
        char[] c2 = s.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                count++;
                if (count>1) return false;
            }
        }
        return true;
    }

    public int ladderLengthAns(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

}

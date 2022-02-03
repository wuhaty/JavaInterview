package Question.mspractice;

import java.util.*;

public class M127 {
    Set<String> allWords;
    String beginWord;
    String endWord;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;
        this.endWord = endWord;
        allWords = new HashSet<>(wordList);
        allWords.add(beginWord);
        if (!allWords.contains(endWord)) return 0;

        int ans = bfs();
        return ans + 1;
    }

    private int bfs() {
        Deque<String> q1 = new ArrayDeque<>(), q2 = new ArrayDeque<>();
        q1.offer(beginWord);
        q2.offer(endWord);
        HashMap<String,Integer> m1 = new HashMap<>();
        HashMap<String,Integer> m2 = new HashMap<>();
        m1.put(beginWord,0);
        m2.put(endWord,0);

        while (!q1.isEmpty() && !q2.isEmpty()){
            int t = -1;
            if (q1.size() < q2.size()){
                t = update(q1,m1,m2);
            }else {
                t = update(q2,m2,m1);
            }

            if (t!=-1) return t;
        }

        return -1;
    }

    private int update(Deque<String> q, HashMap<String, Integer> cur, HashMap<String, Integer> another) {
        int size = q.size();
        while (size-->0){
            String str = q.poll();
            char[] cs = str.toCharArray();

            for (int i = 0; i < cs.length; i++) {
                char t = cs[i];
                for (int j = 0; j < 26; j++) {
                    cs[i] = (char) ('a'+j);
                    String next = String.valueOf(cs);
                    if (allWords.contains(next)){
                        if (cur.containsKey(next) && cur.get(next) <= cur.get(str)+1) continue;
                        if (another.containsKey(next)){
                            return cur.get(str) + 1 + another.get(next);
                        }else {
                            q.offer(next);
                            cur.put(next,cur.get(str)+1);
                        }
                    }
                }
                cs[i] = t;
            }
        }
        return -1;
    }
}

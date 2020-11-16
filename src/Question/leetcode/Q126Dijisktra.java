package Question.leetcode;


import java.util.*;

public class Q126Dijisktra {

    public static void main(String argc[]) {
        Q126Dijisktra q = new Q126Dijisktra();
        List<String> temp = new LinkedList<>();
        temp.add("hot");
        temp.add("dot");
        temp.add("dog");
        temp.add("lot");
        temp.add("log");
        temp.add("cog");
        q.findLadders("hit", "cog", temp);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        List<String> temp = new LinkedList<>();

        Map<String, List<String>> g = new HashMap<>();
        buildGraph(g, beginWord, endWord, wordList);
        backtrack(result, temp, beginWord, endWord, g);
        return result;
    }

    private void buildGraph(Map<String, List<String>> g, String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        int min = Integer.MAX_VALUE;

        Map<String, Integer> dis = new HashMap<>();

        for (String s : wordList) {
            dis.put(s, Integer.MAX_VALUE);
        }
        dis.put(beginWord, 0);
        wordList.add(endWord);

        while (!q.isEmpty()) {
            String curr = q.poll();
            int step = dis.get(curr) + 1;

            if (step > min) break;

            for (int i = 0; i < curr.length(); i++) {
                StringBuilder sb = new StringBuilder(curr);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String newStr = sb.toString();

                    if (dis.containsKey(newStr)) {
                        if (step > dis.get(newStr)){
                            continue;
                        }else if (step < dis.get(newStr)){
                            q.offer(newStr);
                            dis.put(newStr,step);
                        }

                        if (g.containsKey(newStr)){
                            g.get(newStr).add(curr);
                        }else{
                            List<String> l = new LinkedList<>();
                            l.add(curr);
                            g.put(newStr,l);
                        }

                        if (newStr.equals(endWord)){
                            min = step;
                        }
                    }
                }
            }
        }
    }

    private void backtrack(List<List<String>> result, List<String> temp,String beginWord, String endWord, Map<String, List<String>> g){
        if (endWord.equals(beginWord)){
            temp.add(0,beginWord);
            result.add(new LinkedList<>(temp));
            temp.remove(0);
            return;
        }

        temp.add(0,endWord);

        if (g.containsKey(endWord)){
            for (String s:g.get(endWord)) {
                backtrack(result,temp,beginWord,s,g);
            }
        }
        temp.remove(0);
    }

}

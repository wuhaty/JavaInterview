package Question.leetcode;

import java.util.*;

/**
 * Created by gump on 2017/5/10.
 */
public class Q17 {

    char reflect[][] =
            {{' '}, null, {'a', 'b', 'c'}
                    , {'d', 'e', 'f'}
                    , {'g', 'h', 'i'}
                    , {'j', 'k', 'l'}
                    , {'m', 'n', 'o'}
                    , {'p', 'q', 'r', 's'}
                    , {'t', 'u', 'v'}
                    , {'w', 'x', 'y', 'z'}};

    public static void main(String argc[]) {
        Q17 q = new Q17();
        System.out.println(q.letterCombinations2021_queue("23"));
    }

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public List<String> letterCombinationsOri(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;

        LinkedList<String> container = new LinkedList<>();

        char input[] = digits.toCharArray();

        for (char c : input) {
            int i = container.size();
            for (char r : reflect[c - '0']) {
                if (i == 0) {
                    container.addFirst(r + "");
                } else {
                    int j = 0;
                    while (j < i) {
                        StringBuilder sb = new StringBuilder(container.get(j));
                        sb.append(r);
                        container.addLast(sb.toString());
                        j++;
                    }
                }
            }

            while (i > 0) {
                container.removeFirst();
                i--;
            }
        }

        container.forEach(it -> result.add(it.toString()));
        return result;
    }

    public List<String> letterCombinations2021(String digits) {
        List<String> res = new LinkedList<>();
        char[] cs = digits.toCharArray();
        if(cs.length ==0) return res;

        dfs(cs,0,res,new StringBuilder());

        return res;
    }

    private void dfs(char[] cs, int i, List<String> res,StringBuilder sb) {
        if (i>=cs.length) {
            res.add(sb.toString());
            return;
        }

        for (char c:reflect[cs[i]-'0']) {
            sb.append(c);
            dfs(cs,i+1,res,sb);
            sb.deleteCharAt(i);
        }
    }

    public List<String> letterCombinations2020(String digits) {
        List<String> ans = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        helper2020(digits, ans, 0, sb);

        return ans;
    }

    private void helper2020(String digits, List<String> ans, int i, StringBuilder sb) {
        if (i == (digits.length())) {
            ans.add(sb.toString());
            return;
        }

        int index = (digits.charAt(i) - '0');
        for (int k = 0; k < reflect[index].length; k++) {
            sb.append(reflect[index][k]);
            helper2020(digits, ans, i + 1, sb);
            sb.deleteCharAt(i);
        }
    }

    public List<String> letterCombinations2021_backtrack(String digits) {
        List<String> res = new LinkedList<>();
        if (null == digits || digits.isEmpty() ) return res;


        backtrack(new StringBuilder(),digits,res,0);
        return res;
    }

    private void backtrack(StringBuilder sb, String digits, List<String> res, int i) {
        if (i == digits.length()){
            res.add(sb.toString());
            return;
        }

        int index = digits.charAt(i)-'0';
        for (int j = 0; j < reflect[index].length; j++) {
            sb.append(reflect[index][j]);
            backtrack(sb,digits,res,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> letterCombinations2021_queue(String digits){
        List<String> res = new LinkedList<>();
        if (digits==null || digits.isEmpty()) return res;

        Queue<String> q = new LinkedList<>();
        char cs[] = digits.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            if (q.size()==0){
                for (int j = 0; j < reflect[cs[i]-'0'].length; j++) {
                    q.offer(reflect[cs[i]-'0'][j]+"");
                }
            }else{
                int index = cs[i]-'0';
                int size = q.size();
                int count = 0;
                while (count<size) {
                    String s = q.poll();

                    for (int j = 0; j < reflect[cs[i]-'0'].length; j++) {
                        q.offer(s+reflect[cs[i]-'0'][j]);
                    }
                    count++;
                }
            }
        }
        res.addAll(q);
        return res;
    }
}

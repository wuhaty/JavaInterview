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
        System.out.println(q.letterCombinations2020("23"));
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

}

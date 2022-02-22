package Question.leetcode.book.interviewSummary;

public class I387 {
    public int firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        int[] count = new int[26];

        for (char c : cs) {
            count[c-'a']++;
        }

        for (int i = 0; i < cs.length; i++) {
            if (count[cs[i]-'a'] == 1) return i;
        }

        return -1;
    }
}

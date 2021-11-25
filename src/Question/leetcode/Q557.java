package Question.leetcode;

/**
 * Created by gump on 2017/5/6.
 */
public class Q557 {
    public String reverseWords(String s) {
        char input[] = s.toCharArray();

        for (int i = 0,j=0; i < input.length; i++) {
            if(input[i]!=' '){
                j++;
            }

            if(input[i]==' ' || i==input.length-1){
                if(i==input.length-1) i++;
                int start = i-j;
                int end = i-1;
                while (start<end){
                    char temp = input[start];
                    input[start] = input[end];
                    input[end] = temp;
                    start++;end--;
                }
                j=0;
            }
        }
        return new String(input);
    }

    public static void main(String[] args) {
        Q557 q = new Q557();
        q.reverseWords2021("Let's take LeetCode contest");
    }

    public String reverseWords2021(String s) {
        if (s== null) return null;

        char[] cs = s.toCharArray();

        int left = 0;
        int right = 0;
        int n = cs.length;
        while (left < n) {
            while (right< n && cs[right] != ' '){
                right++;
            }
            swap(cs,left,right-1);
            right++;
            left = right;
        }
        return new String(cs);
    }

    private void swap(char[] cs, int left, int right) {
        while (left<cs.length && right>=0&&left<right) {
            char t = cs[left];
            cs[left] = cs[right];
            cs[right] = t;
            left++;
            right--;
        }
    }
}

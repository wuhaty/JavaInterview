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
}

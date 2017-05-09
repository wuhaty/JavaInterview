package Question.leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by gump on 2017/5/8.
 */
public class Q556 {

    public int nextGreaterElement(int n) {
        String str = String.valueOf(n);
        char input[] = str.toCharArray();

        int i,j;
        for (i = input.length-2; i >0 ; i--) {
            if (input[i] <input[i+1]) break;
        }

        if(i==0) return -1;

        int smallest = i+1;
        for (j = i+1; j < input.length ; j++) {
            if(input[j] > input[i] && input[j]<input[smallest]){
                smallest = j;
            }
        }

        char temp = input[i];
        input[i] = input[smallest];
        input[smallest] = temp;

        Arrays.sort(input,i+1,input.length-1);

        return Integer.parseInt(new String(input));
    }
}

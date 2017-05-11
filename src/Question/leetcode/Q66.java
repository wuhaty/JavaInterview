package Question.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gump on 2017/5/11.
 */
public class Q66 {
    public int[] plusOneOri(int[] digits) {
        ArrayList<Integer> result = new ArrayList<>();
        int charge = 1;
        for (int i = digits.length-1; i >=0 ; i--) {
            if(digits[i]+charge < 10){
                result.add(0,digits[i]+charge);
                charge = 0;
            }else{
                result.add(0,(digits[i]+charge)%10);
                charge = 1;
            }
        }

        if (charge==1) result.add(0,1);

        int container[] = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            container[i] = result.get(i);
        }
        return container;
    }

    public int[] plusOne(int[] digits) {

        int n = digits.length;
        if(digits[n-1]<9){
            digits[n-1]++;
            return digits;
        }
        digits[n-1] = 0;

        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
            }

            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
}

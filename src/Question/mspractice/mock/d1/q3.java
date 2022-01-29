package Question.mspractice.mock.d1;

import java.util.*;

public class q3 {
    public static void main(String[] args) {
        q3 q = new q3();
//        System.out.println(q.fractionToDecimal(1,2));
//        System.out.println(q.fractionToDecimal(2,1));
//        System.out.println(q.fractionToDecimal(1,5));
        System.out.println(q.fractionToDecimal(22,7));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        if (numeratorLong%denominatorLong == 0){
            return String.valueOf(numeratorLong/denominatorLong);
        }


        StringBuilder sb = new StringBuilder();


        if (numerator<0 ^ denominator<0) {
            sb.append("-");
        }

        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);


        //integer part
        sb.append(numeratorLong/denominatorLong);
        sb.append(".");
        int integerOffset = sb.length();

        //fraction part
        Map<Long,Integer> m = new HashMap<>();
        long reminder = numeratorLong % denominatorLong;
        int index = 0;

        while (reminder != 0 && !m.containsKey(reminder)){
            m.put(reminder,index);
            reminder *=10;
            sb.append(reminder/denominatorLong);
            reminder%=denominatorLong;
            index++;
        }

        //loop
        if (reminder!=0){
            int i = m.get(reminder);
            sb.insert(integerOffset+i,"(");
            sb.append(")");
        }

        return sb.toString();
    }
}
